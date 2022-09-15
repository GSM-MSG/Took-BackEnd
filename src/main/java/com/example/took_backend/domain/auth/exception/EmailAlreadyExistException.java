package com.example.took_backend.domain.auth.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class EmailAlreadyExistException extends RuntimeException {
    private ErrorCode errorCode;

    public EmailAlreadyExistException(String message) {
        super(message);
        this.errorCode = ErrorCode.EMAIL_ALREADY_EXIST;
    }
}
