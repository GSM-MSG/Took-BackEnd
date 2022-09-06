package com.example.took_backend.domain.email.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ManyRequestEmailAuthException extends RuntimeException{
    private final ErrorCode errorCode;

    public ManyRequestEmailAuthException(String message){
        super(message);
        this.errorCode = ErrorCode.AUTH_CODE_EXPIRED;
    }
}