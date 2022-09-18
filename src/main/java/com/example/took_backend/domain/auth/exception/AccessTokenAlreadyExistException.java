package com.example.took_backend.domain.auth.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccessTokenAlreadyExistException extends RuntimeException{
    private final ErrorCode errorCode;

    public AccessTokenAlreadyExistException(String message){
        super(message);
        this.errorCode = ErrorCode.ACCESS_TOKEN_ALREADY_EXIST;
    }
}
