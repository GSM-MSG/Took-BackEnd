package com.example.took_backend.global.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TookException extends RuntimeException{
    private final ErrorCode errorCode;

    public TookException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
