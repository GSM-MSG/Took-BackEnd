package com.example.took_backend.domain.business_card.service;

import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.entity.CardExchange;
import com.example.took_backend.domain.business_card.presentation.dto.response.ExchangeCardListResponse;
import com.example.took_backend.domain.business_card.repository.CardExchangeRepository;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PrePersist;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExchangeCardListService {
    private final CardExchangeRepository cardExchangeRepository;
    private final UserUtil userUtil;
    @Transactional(readOnly = true)
    public List<ExchangeCardListResponse> execute() {
        User user = userUtil.currentUser();
        List<CardExchange> cardExchange = cardExchangeRepository.findAllByUser(user);
        List<BusinessCard> businessCardList = getBusinessCardList(cardExchange);
        List<ExchangeCardListResponse> exchangeCardListResponses = getBusinessCardInfoList(businessCardList);
        return exchangeCardListResponses;
    }

    @PrePersist
    private List<ExchangeCardListResponse> getBusinessCardInfoList(List<BusinessCard> businessCardList) {
        List<ExchangeCardListResponse> list = businessCardList.stream().map(cardInfo-> ExchangeCardListResponse.builder()
                .uuid(cardInfo.getUuid())
                .frontUrl(cardInfo.getFrontUrl())
                .backUrl(cardInfo.getBackUrl())
                .createdAt(cardInfo.getCreatedAt())
                .updatedAt(cardInfo.getUpdatedAt())
                .build()).collect(Collectors.toList());
        return list;
    }

    private List<BusinessCard> getBusinessCardList(List<CardExchange> cardExchange) {
        List<BusinessCard> list = cardExchange.stream().map(CardExchange::getBusinessCard).collect(Collectors.toList());
        return list;
    }
}
