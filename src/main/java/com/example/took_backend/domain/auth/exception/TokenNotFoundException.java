package com.example.took_backend.domain.auth.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TokenNotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public TokenNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_NOT_VALID;
    }
}
