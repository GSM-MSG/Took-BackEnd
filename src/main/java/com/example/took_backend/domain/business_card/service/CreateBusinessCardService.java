package com.example.took_backend.domain.business_card.service;

import com.example.took_backend.domain.business_card.repository.BusinessCardRepository;
import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.presentation.dto.request.CreateBusinessCardRequest;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBusinessCardService {
    private final BusinessCardRepository businessCardRepository;
    private final UserUtil userUtil;
    public void execute(CreateBusinessCardRequest createBusinessCardRequest){
        User userInfo = userUtil.currentUser();
        BusinessCard businessCard = BusinessCard.builder()
                .frontUrl(createBusinessCardRequest.getFrontUrl())
                .backUrl(createBusinessCardRequest.getBackUrl())
                .user(userInfo)
                .build();
        businessCardRepository.save(businessCard);
    }
}
