package com.example.took_backend.domain.email.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AuthCodeExpiredException extends RuntimeException{
    private final ErrorCode errorCode;

    public AuthCodeExpiredException(String message){
        super(message);
        this.errorCode = ErrorCode.EMAIL_SEND_FAIL;
    }
}