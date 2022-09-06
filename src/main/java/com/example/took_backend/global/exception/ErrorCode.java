package com.example.took_backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 에러입니다."),
    TOKEN_EXPIRATION(HttpStatus.UNAUTHORIZED, "토큰이 만료 되었습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
