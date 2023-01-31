package com.reto2.grupo3.controllers;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarCorreo {
    // Server mail user & pass account
    private String user = null;
    private String pass = null;

    // DNS Host + SMTP Port
    private String smtp_host = "smtp.gmail.com";
    private int smtp_port = 465;

    @SuppressWarnings("unused")
    private EnviarCorreo() {
    }

    /**
     * Builds the EmailService.
     *
     * @param user User account login
     * @param pass User account password
     */
    public EnviarCorreo(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    /**
     * Sends the given <b>text</b> from the <b>sender</b> to the <b>receiver</b>. In
     * any case, both the <b>sender</b> and <b>receiver</b> must exist and be valid
     * mail addresses. The sender, mail's FROM part, is taken from this.user by
     * default<br/>
     * <br/>
     *
     * Note the <b>user</b> and <b>pass</b> for the authentication is provided in
     * the class constructor. Ideally, the <b>sender</b> and the <b>user</b>
     * coincide.
     *
     * @param receiver The mail's TO part
     * @param subject  The mail's SUBJECT
     * @param text     The proper MESSAGE
     * @throws MessagingException Is something awry happens
     *
     */
    private void sendMail(String receiver, String subject, String text) throws MessagingException {

        // Mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtp_host);
        properties.put("mail.smtp.port", smtp_port);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", smtp_host);
        properties.put("mail.imap.partialfetch", false);

        // Authenticator knows how to obtain authentication for a network connection.
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        // MIME message to be sent
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver)); // Ej: receptor@gmail.com
        message.setSubject(subject); // Asunto del mensaje

        // A mail can have several parts
        Multipart multipart = new MimeMultipart();

        // A message part (the message, but can be also a File, etc...)
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(text, "text/html");
        multipart.addBodyPart(mimeBodyPart);

        // Adding up the parts to the MIME message
        message.setContent(multipart);

        // And here it goes...
        Transport.send(message);
    }

    String generateRandomPassword(int len) {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public String enviarCorreoReset(String email, String randomPass) {
        String subject = "Nueva contraseña app";
        String message = "Su nueva contraseña es" + randomPass;

        try {
            sendMail(email, subject, message);
            System.out.println("Ok, mail sent!");
        } catch (MessagingException e) {
            System.out.println("Doh! " + e.getMessage());
        }
        return null;
    }
}
