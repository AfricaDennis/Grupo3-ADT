package com.reto2.grupo3.security;



import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.reto2.grupo3.model.User.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
	// asignamos tiempo de validez del token. A partir de ahi no podra utilizarlo.
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24
	// mas adelante veremos como actualizar sin volver a hacer login
	
	// con la siguiente linea asigna a la SECRET_KEY nuestro app.jwt.secret del application.properties
	@Value("${app.jwt.secret}")
	private String SECRET_KEY;
	
	public String generateAccessToken(User user) {
		// cuando generamos el token podemos meter campos custom que nos puedan ser utiles mas adelante.
		return Jwts.builder()
				.setSubject(String.format("%s,%s", user.getId(), user.getEmail()))
				.setIssuer("ADTDAM")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				// .claim("userId", user.getId()) // podriamos meter datos custom, u objetos custom. ojo con meter "user" por que tiene la password en el modelo 
				// y passwords no queremos enviar ni devolver
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}
	
	public boolean validateAccessToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException ex) {
			LOGGER.error("JWT expired", ex.getMessage());
		} catch (IllegalArgumentException ex) {
			LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
		} catch (MalformedJwtException ex) {
			LOGGER.error("JWT is invalid", ex);
		} catch (UnsupportedJwtException ex) {
			LOGGER.error("JWT is not supported", ex);
		} catch (SignatureException ex) {
			LOGGER.error("Signature validation failed");
		}
		
		return false;
	}
	
	public String getSubject(String token) {
		return parseClaims(token).getSubject();
	}
	
	private Claims parseClaims(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	}
}
