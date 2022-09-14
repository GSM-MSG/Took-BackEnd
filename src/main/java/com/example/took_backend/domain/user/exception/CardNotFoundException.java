package com.example.took_backend.domain.user.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CardNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public CardNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.CARD_NOT_FOUND;
    }
}
