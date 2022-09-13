package com.example.took_backend.domain.user.service;

import com.example.took_backend.domain.business_card.BusinessCard;
import com.example.took_backend.domain.business_card.repository.BusinessCardRepository;
import com.example.took_backend.domain.user.User;
import com.example.took_backend.domain.user.exception.CardNotFoundException;
import com.example.took_backend.domain.user.presentation.dto.response.MyCardInfoDto;
import com.example.took_backend.domain.user.repository.UserRepository;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindCardInfoService {
    private final UserRepository userRepository;
    private final BusinessCardRepository businessCardRepository;

    public MyCardInfoDto findCardInfo(){
        String email = "127469@naver.com"; //TODO 토큰에서 메일 가져오는 함수 만들면 변경하기 -김시훈-
        User user = userRepository.findUserByEmail(email).orElseThrow(()-> new UserNotFoundException("유저가 없습니다"));
        return toResponse(businessCardRepository.findBusinessCardByUser(user).orElseThrow(()-> new CardNotFoundException("명함이 없습니다")));
    }
    public MyCardInfoDto toResponse(BusinessCard businessCard){
        return MyCardInfoDto.builder()
                .uuid(businessCard.getUuid())
                .frontUrl(businessCard.getFrontUrl())
                .backUrl(businessCard.getBackUrl())
                .createdAt(businessCard.getCreatedAt())
                .updatedAt(businessCard.getUpdatedAt())
                .build();
    }
}
