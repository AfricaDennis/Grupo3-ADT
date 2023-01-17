package com.reto2.grupo3.security;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.reto2.grupo3.model.User.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

	private static final String USER_ID_CLAIM = "userId";
	private static final String USER_ADMIN_CLAIM = "isAdmin";
	
	public String generateAccessToken(User user) {
		// cuando generamos el token podemos meter campos custom que nos puedan ser utiles mas adelante.
		return Jwts.builder()
				.setSubject(String.format("%s", user.getEmail()))
				.setIssuer("ADTDAM")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))

				.claim(USER_ID_CLAIM, user.getId())
				.claim(USER_ADMIN_CLAIM, user.isAdmin())

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

	public Integer getUserId(String token){
		Claims claims = parseClaims(token);
		return (Integer) claims.get(USER_ID_CLAIM);
	}

	public boolean getIsAdmin(String token){
		Claims claims = parseClaims(token);
		return (boolean) claims.get(USER_ADMIN_CLAIM);
	}

	private Claims parseClaims(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	}

	public static <T> List<T> jsonArrayToList(Object json, Class<T> elementClass) throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(json);
		CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
		return objectMapper.readValue(jsonString,listType);
	}
}
