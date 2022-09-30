package com.example.took_backend.domain.business_card.service;

import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.entity.CardExchange;
import com.example.took_backend.domain.business_card.entity.CardExchangeId;
import com.example.took_backend.domain.business_card.exception.BusinessCardNotFoundException;
import com.example.took_backend.domain.business_card.presentation.dto.request.ExChangeBusinessCardRequest;
import com.example.took_backend.domain.business_card.presentation.dto.response.ExchangeCardResponse;
import com.example.took_backend.domain.business_card.repository.BusinessCardRepository;
import com.example.took_backend.domain.business_card.repository.CardExchangeRepository;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.domain.user.repository.UserRepository;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class ExChangeCardService {
    private final UserUtil userUtil;
    private final CardExchangeRepository cardExchangeRepository;
    private final BusinessCardRepository businessCardRepository;
    public ExchangeCardResponse BusineessCardExchange(ExChangeBusinessCardRequest uuid) {
        User currentUser = userUtil.currentUser();
        BusinessCard businessCard = businessCardRepository.findById(uuid.getUuid())
                .orElseThrow(() -> new BusinessCardNotFoundException("명함을 찾을 수 없습니다."));
        if(businessCard.getUser().getUuid().isEmpty()) {
            throw new UserNotFoundException("교환할 상대방을 찾을 수 없습니다.");
        }
        CardExchange cardExchange = CardExchange.builder()
                .user(currentUser)
                .businessUser(businessCard.getUser())
                .businessCard(businessCard)
                .build();
        cardExchangeRepository.save(cardExchange);
        return new ExchangeCardResponse(businessCard);

    }
}
