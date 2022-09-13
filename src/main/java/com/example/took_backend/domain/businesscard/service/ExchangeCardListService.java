package com.example.took_backend.domain.businesscard.service;

import com.example.took_backend.domain.businesscard.entity.BusinessCard;
import com.example.took_backend.domain.businesscard.entity.CardExchange;
import com.example.took_backend.domain.businesscard.presentation.dto.response.ExchangeCardListResponse;
import com.example.took_backend.domain.businesscard.repository.CardExchangeRepository;
import com.example.took_backend.domain.user.User;
import com.example.took_backend.domain.user.repository.UserRepository;
import com.example.took_backend.global.exception.exceptionCollection.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExchangeCardListService {
    private final CardExchangeRepository cardExchangeRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ExchangeCardListResponse> execute() {
        String email = "토큰에서 가져온 이메일"; //TODO 토큰에서 이메일 가져오는 로직 추가시 변경
        User userInfo = userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("유저가 존재하지 않음"));
        List<CardExchange> cardExchange = cardExchangeRepository.findAllByUser(userInfo);
        List<BusinessCard> businessCardList = getBusinessCardList(cardExchange);
        List<ExchangeCardListResponse> exchangeCardListResponses = getBusinessCardInfoList(businessCardList);
        return exchangeCardListResponses;
    }

    private List<ExchangeCardListResponse> getBusinessCardInfoList(List<BusinessCard> businessCardList) {
        List<ExchangeCardListResponse> list = businessCardList.stream().map(cardInfo->
                new ExchangeCardListResponse(cardInfo.getUuid(),cardInfo.getFrontUrl(),cardInfo.getBackUrl(),cardInfo.getCreatedAt(),cardInfo.getUpdatedAt()))
                .collect(Collectors.toList());
        return list;
    }

    private List<BusinessCard> getBusinessCardList(List<CardExchange> cardExchange) {
        List<BusinessCard> list = cardExchange.stream().map(CardExchange::getBusinessCard).collect(Collectors.toList());
        return list;
    }
}
