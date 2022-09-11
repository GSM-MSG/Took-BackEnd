package com.example.took_backend.domain.businesscard.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateBusinessCardRequest {
    private final String frontUrl;
    private final String backUrl;
}
