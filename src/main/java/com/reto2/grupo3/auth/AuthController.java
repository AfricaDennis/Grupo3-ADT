package com.reto2.grupo3.auth;


//import javax.validation.Valid;

import com.reto2.grupo3.auth.exception.UserCantCreateException;
import com.reto2.grupo3.auth.model.AuthRequest;
import com.reto2.grupo3.auth.model.AuthResponse;
import com.reto2.grupo3.model.User.User;
import com.reto2.grupo3.model.User.UserPostRequest;
import com.reto2.grupo3.repository.UserRepository;
import com.reto2.grupo3.security.JwtTokenUtil;
import com.reto2.grupo3.service.User.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


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

@RestController
@RequestMapping("api")
public class AuthController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    @Autowired
    UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getId(), user.getEmail(), accessToken, user.isAdmin());

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/auth/signup")
    public ResponseEntity<?> signIn(@RequestBody AuthRequest request) {
        // TODO solo esta creado en el caso de que funcione. Si no es posible que de 500
        //User user = new User(request.getEmail(), request.getPassword());
        //return new ResponseEntity<Integer>(userService.create(user), HttpStatus.CREATED);
        User user = new User(request.getName(), request.getSurname(), request.getPassword(), request.getEmail(), request.getPhone(),request.isAdmin());
        try{
            userService.signUp(user);
        }catch (UserCantCreateException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/auth/me")
    public ResponseEntity<?> getUserInfo(Authentication authentication) {
        User userDetails = (User) authentication.getPrincipal();
        return ResponseEntity.ok().body(userDetails);
    }

    @PostMapping("/auth/cambiopass/{email}/{password}")
    public ResponseEntity<?> actualizarpass(@PathVariable("email") String email,@PathVariable("password") String password, @RequestBody UserPostRequest userPostRequest) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            User user = (User) authentication.getPrincipal();
            AuthResponse response = new AuthResponse(user.getId(), user.getEmail());

            return new ResponseEntity<>(userService.updateUser(response.getId(),userPostRequest), HttpStatus.NO_CONTENT);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}