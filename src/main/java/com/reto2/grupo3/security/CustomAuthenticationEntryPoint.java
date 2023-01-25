package com.reto2.grupo3.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

public class CustomAuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if(response.getStatus() == HttpServletResponse.SC_FORBIDDEN){
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Authorization Failed");
        }
        else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization Failed");
        }
    }
}
