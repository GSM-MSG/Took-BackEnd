package com.example.took_backend.domain.business_card.service;

import com.example.took_backend.domain.business_card.repository.BusinessCardRepository;
import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.presentation.dto.request.CreateBusinessCardRequest;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBusinessCardService {
    private final BusinessCardRepository businessCardRepository;
    private final UserRepository userRepository;

    public void execute(CreateBusinessCardRequest createBusinessCardRequest){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User userInfo = userRepository.findUserByEmail(email).orElseThrow(()-> new UserNotFoundException("유저를 찾을 수 없습니다."));
        BusinessCard businessCard = BusinessCard.builder()
                .frontUrl(createBusinessCardRequest.getFrontUrl())
                .backUrl(createBusinessCardRequest.getBackUrl())
                .user(userInfo)
                .build();
        businessCardRepository.save(businessCard);
    }
}
