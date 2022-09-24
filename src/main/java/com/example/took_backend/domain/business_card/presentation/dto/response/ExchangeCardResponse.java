package com.example.took_backend.domain.business_card.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class ExchangeCardResponse {
    private final String uuid;
    private final String frontUrl;
    private final String backUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD'T'HH:mm:ss")
    private final ZonedDateTime createdAt;

}
