package com.example.took_backend.domain.businesscard.presentation.dto.request;

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
