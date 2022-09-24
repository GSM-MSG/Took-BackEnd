package com.example.took_backend.domain.business_card.service;

import com.example.took_backend.domain.business_card.presentation.dto.response.ExchangeCardResponse;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.repository.UserRepository;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExChangeCardService {
    private final UserUtil userUtil;
    private final UserRepository userRepository;

    public void BusineessCardExchange(String uuid) {
        User currentUser = userUtil.currentUser();
        currentUser.getBusinessCard();

    }
}
