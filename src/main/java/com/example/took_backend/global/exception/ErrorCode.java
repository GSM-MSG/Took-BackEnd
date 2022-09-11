package com.example.took_backend.global.exception;

import com.example.took_backend.domain.email.exception.AuthCodeExpiredException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    TOKEN_EXPIRATION("토큰이 만료 되었습니다.", 401),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    MANY_REQUEST_EMAIL_AUTH("15분에 최대 3번 이메일 인증을 요청할 수 있습니다.", 429),
    UNKNOWN("알 수 없는 에러", 500),
    AUTH_CODE_EXPIRED("메일 발송에 실패 했습니다",500);
    private final String message;
    private final int status;
}
