package com.example.took_backend.domain.businesscard.data.response;

import com.example.took_backend.domain.businesscard.BusinessCard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ExchangeCardListResponse {
    private final String uuid;
    private final String frontUrl;
    private final String backUrl;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
