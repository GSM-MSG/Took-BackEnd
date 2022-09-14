package com.example.took_backend.domain.business_card.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class CreateBusinessCardRequest {
    @NotBlank(message = "명함 앞면을 넣어주세요")
    private final String frontUrl;
    @NotBlank(message = "명함 뒷면을 넣어주세요")
    private final String backUrl;
}
