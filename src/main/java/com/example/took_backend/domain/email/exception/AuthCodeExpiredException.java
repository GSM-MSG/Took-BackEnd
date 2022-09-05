package com.example.took_backend.domain.email.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AuthCodeExpiredException extends RuntimeException{
    private ErrorCode errorCode;

    public AuthCodeExpiredException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
