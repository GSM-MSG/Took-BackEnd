package com.example.took_backend.domain.business_card.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class CreateBusinessCardRequest {
    @NotBlank
    private final String frontUrl;
    @NotBlank
    private final String backUrl;
}
