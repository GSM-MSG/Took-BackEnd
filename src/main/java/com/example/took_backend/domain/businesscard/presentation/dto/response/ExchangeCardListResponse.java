package com.example.took_backend.domain.businesscard.presentation.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ExchangeCardListResponse {
    private final String uuid;
    private final String frontUrl;
    private final String backUrl;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
