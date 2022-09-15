package com.example.took_backend.domain.auth.presentation.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignInResponse {
    private String accessToken;
    private String refreshToken;
    private Date expiredAt;
}
