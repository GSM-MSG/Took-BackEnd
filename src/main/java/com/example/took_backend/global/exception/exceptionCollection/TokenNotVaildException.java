package com.example.took_backend.global.exception.exceptionCollection;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenNotVaildException extends RuntimeException {

    private final ErrorCode errorCode;

    public TokenNotVaildException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_NOT_VALID;
    }
}
