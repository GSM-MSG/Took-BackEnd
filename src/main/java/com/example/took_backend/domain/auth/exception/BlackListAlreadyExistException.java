package com.example.took_backend.domain.auth.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BlackListAlreadyExistException extends RuntimeException{
    private final ErrorCode errorCode;

    public BlackListAlreadyExistException(String message){
        super(message);
        this.errorCode = ErrorCode.BLACK_LIST_ALREADY_EXIST;
    }
}
