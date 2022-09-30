package com.example.took_backend.domain.business_card.presentation.dto.response;

import com.example.took_backend.domain.business_card.entity.BusinessCard;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final ZonedDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final ZonedDateTime updatedAt;

    public ExchangeCardResponse(BusinessCard businessCard) {
        this.uuid = businessCard.getUuid();
        this.frontUrl = businessCard.getFrontUrl();
        this.backUrl = businessCard.getBackUrl();
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = businessCard.getUpdatedAt();
    }

}
