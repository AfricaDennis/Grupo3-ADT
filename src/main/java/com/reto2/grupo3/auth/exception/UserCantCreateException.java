package com.reto2.grupo3.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.CONFLICT, reason = "Couldn´t create the user")
public class UserCantCreateException extends Exception{
    private static final long serialVersionUID =1L;

    public UserCantCreateException(String errorMessage){
        super(errorMessage);
    }
}
