package com.example.took_backend.domain.business_card.service;

import com.example.took_backend.domain.business_card.repository.BusinessCardRepository;
import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.presentation.dto.request.CreateBusinessCardRequest;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateBusinessCardService {
    private final BusinessCardRepository businessCardRepository;
    private final UserUtil userUtil;

    @Transactional(rollbackFor = Exception.class)
    public void execute(CreateBusinessCardRequest createBusinessCardRequest){
        User user = userUtil.currentUser();
        BusinessCard businessCard = BusinessCard.builder()
                .frontUrl(createBusinessCardRequest.getFrontUrl())
                .backUrl(createBusinessCardRequest.getBackUrl())
                .user(user)
                .build();
        businessCardRepository.save(businessCard);
    }
}
