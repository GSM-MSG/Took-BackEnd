package com.example.took_backend.domain.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewTokenResponse {
    private String accessToken;
    private String refreshToken;
    private ZonedDateTime expiredAt;
}
