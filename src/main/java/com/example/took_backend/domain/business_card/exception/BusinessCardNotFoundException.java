package com.example.took_backend.domain.business_card.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessCardNotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public BusinessCardNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.BUSINESSCARD_NOT_FOUND;
    }
}
