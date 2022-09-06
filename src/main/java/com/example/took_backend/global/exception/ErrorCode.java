package com.example.took_backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNKNOWN("알 수 없는 에러", 500),
    AUTH_CODE_EXPIRED("메일 발송에 실패 했습니다",500),
    AUTH_CODE_MISMATCH("인증번호가 일치하지 않습니다,",400),
    USER_NOT_FOUND("유저를 찾을 수 없습니다.",404),
    MANY_REQUEST_EMAIL_AUTH("15분에 최대 3번 이메일 인증을 요청할 수 있습니다.", 429);
    private final String message;
    private final int status;
}
