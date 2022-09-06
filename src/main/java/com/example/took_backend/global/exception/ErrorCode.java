package com.example.took_backend.global.exception;

import com.example.took_backend.domain.email.exception.AuthCodeExpiredException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNKNOWN("알 수 없는 에러", 500),
    AUTH_CODE_EXPIRED("메일 발송에 실패 했습니다",500);
    private final String message;
    private final int status;
}
