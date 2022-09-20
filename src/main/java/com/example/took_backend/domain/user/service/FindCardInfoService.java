package com.example.took_backend.domain.user.service;

import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.repository.BusinessCardRepository;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.exception.CardNotFoundException;
import com.example.took_backend.domain.user.presentation.dto.response.MyCardInfoResponse;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindCardInfoService {
    private final BusinessCardRepository businessCardRepository;
    private final UserUtil userUtil;

    public MyCardInfoResponse findCardInfo(){
        User user = userUtil.currentUser();
        return toResponse(businessCardRepository.findBusinessCardByUser(user).orElseThrow(()-> new CardNotFoundException("명함이 없습니다")));
    }
    public MyCardInfoResponse toResponse(BusinessCard businessCard){
        return MyCardInfoResponse.builder()
                .uuid(businessCard.getUuid())
                .frontUrl(businessCard.getFrontUrl())
                .backUrl(businessCard.getBackUrl())
                .createdAt(businessCard.getCreatedAt())
                .updatedAt(businessCard.getUpdatedAt())
                .build();
    }
}
