package com.example.took_backend.domain.user.presentation.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MyCardInfoResponse {
    private String uuid;
    private String frontUrl;
    private String backUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
