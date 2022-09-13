package com.example.took_backend.domain.businesscard.service;

import com.example.took_backend.domain.businesscard.BusinessCard;
import com.example.took_backend.domain.businesscard.data.dto.ExchangeCardListDto;
import com.example.took_backend.domain.cardexhange.CardExchange;
import com.example.took_backend.domain.cardexhange.repository.CardExchangeRepository;
import com.example.took_backend.domain.user.User;
import com.example.took_backend.domain.user.repository.UserRepository;
import com.example.took_backend.global.exception.exceptionCollection.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeCardListService {
    private final CardExchangeRepository cardExchangeRepository;
    private final UserRepository userRepository;

    public ExchangeCardListDto execute() {
        String email = "토큰에서 가져온 이메일"; //TODO 토큰에서 이메일 가져오는 로직 추가시 변경
        User user = userRepository.findUserByEmail("s21068@gsm.hs.kr").orElseThrow(() -> new UserNotFoundException("유저가 존재하지 않음"));
        List<CardExchange> cardExchange = cardExchangeRepository.findAllByUser(user);
        List<BusinessCard> businessCardList = getBusinessCardList(cardExchange);
        ExchangeCardListDto cardListDto = new ExchangeCardListDto(businessCardList);
        System.out.println(cardListDto);
        return cardListDto;
    }

    private List<BusinessCard> getBusinessCardList(List<CardExchange> cardExchange) {
        List<BusinessCard> list = new ArrayList();
        cardExchange.forEach(card->{
            list.add(card.getBusinessCard());
        });
        return list;
    }

}
