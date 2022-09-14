package com.example.took_backend.domain.business_card.service;

import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.entity.CardExchange;
import com.example.took_backend.domain.business_card.repository.CardExchangeRepository;
import com.example.took_backend.domain.business_card.presentation.dto.response.ExchangeCardListResponse;
import com.example.took_backend.domain.user.User;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        User userInfo = userRepository.findUserByEmail("s21068@gsm.hs.kr").orElseThrow(() -> new UserNotFoundException("유저가 존재하지 않음"));
        List<CardExchange> cardExchange = cardExchangeRepository.findAllByUser(userInfo);
        List<BusinessCard> businessCardList = getBusinessCardList(cardExchange);
        List<ExchangeCardListResponse> exchangeCardListResponses = getBusinessCardInfoList(businessCardList);
        return exchangeCardListResponses;
    }

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
