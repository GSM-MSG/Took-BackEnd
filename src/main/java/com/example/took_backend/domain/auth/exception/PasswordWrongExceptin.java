package com.example.took_backend.domain.auth.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class PasswordWrongExceptin extends RuntimeException {
    private ErrorCode errorCode;

    public PasswordWrongExceptin(String message) {
        super(message);
        this.errorCode = ErrorCode.PASSWORD_WRONG;
    }
}
