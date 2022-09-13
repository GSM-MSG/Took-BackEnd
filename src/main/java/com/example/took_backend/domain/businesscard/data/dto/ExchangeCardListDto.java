package com.example.took_backend.domain.businesscard.data.dto;

import com.example.took_backend.domain.businesscard.BusinessCard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ExchangeCardListDto {
    private final List<BusinessCard> businessCardList;

}
