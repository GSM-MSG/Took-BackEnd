package com.example.took_backend.global.exception.exceptionCollection;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public UserNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.USER_NOT_FOUND;
    }
}
