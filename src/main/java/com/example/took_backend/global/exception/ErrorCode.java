package com.example.took_backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNKNOWN_ERROR("알 수 없는 에러입니다.", 500),
    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401);

    private final String message;
    private final int status;
}
