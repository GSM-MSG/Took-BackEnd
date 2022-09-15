package com.example.took_backend.domain.auth.service;

import com.example.took_backend.domain.auth.entity.BlackList;
import com.example.took_backend.domain.auth.entity.RefreshToken;
import com.example.took_backend.domain.auth.repository.BlackListRepository;
import com.example.took_backend.domain.auth.repository.RefreshTokenRepository;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class LogoutService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final BlackListRepository  blackListRepository;
    public void execute(){
        String email = "토큰에서 가져온 이메일";
        if(refreshTokenRepository.existsById(email)) throw new UserNotFoundException("유저가 존재하지 않습니다.");
        refreshTokenRepository.deleteById(email);
        saveBlackList(email);
    }
    private void saveBlackList(String email){
        String accessToken = "엑세스 토큰";
        BlackList blackList = BlackList.builder()
                .email(email)
                .accessToken(accessToken)
                .build(); //timeToLive 토큰기간으로 하기
        blackListRepository.save(blackList);

    }
}
