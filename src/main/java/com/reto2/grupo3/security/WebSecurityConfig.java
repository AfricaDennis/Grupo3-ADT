package com.reto2.grupo3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
	@Autowired 
	private JwtTokenFilter jwtTokenFilter;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	// utilizado para encriptar las contraseñas en la DB
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	// aqui definimos principalmente cuales son las urls van a poder ser accesibles sin identificarse
	// y cuales seran obligatorias
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeHttpRequests(
			(authz) -> authz
					.requestMatchers("/api/auth/**").permitAll()
					.requestMatchers("/api/auth/login").permitAll()
					.anyRequest().authenticated()
		);


		http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());

		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}