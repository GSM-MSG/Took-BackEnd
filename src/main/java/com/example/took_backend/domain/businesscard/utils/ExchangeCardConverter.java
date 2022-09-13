package com.example.took_backend.domain.businesscard.utils;

import com.example.took_backend.domain.businesscard.data.dto.ExchangeCardListDto;
import com.example.took_backend.domain.businesscard.data.response.ExchangeCardListResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExchangeCardConverter {
    public List<ExchangeCardListResponse> toResponse(ExchangeCardListDto exchangeCardListDto){
        List<ExchangeCardListResponse> list = new ArrayList<>();
        exchangeCardListDto.getBusinessCardList().forEach(businessCard -> {
            ExchangeCardListResponse exchangeCardListResponse = new ExchangeCardListResponse(businessCard.getUuid(),businessCard.getFrontUrl(),businessCard.getBackUrl(),businessCard.getCreatedAt(),businessCard.getUpdatedAt());
           list.add(exchangeCardListResponse);
        });
        return list;
    }
}
