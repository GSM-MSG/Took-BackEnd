package com.example.took_backend.domain.auth.service;

import com.example.took_backend.domain.auth.entity.BlackList;
import com.example.took_backend.domain.auth.entity.RefreshToken;
import com.example.took_backend.domain.auth.exception.BlackListAlreadyExistException;
import com.example.took_backend.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.took_backend.domain.auth.repository.BlackListRepository;
import com.example.took_backend.domain.auth.repository.RefreshTokenRepository;
import com.example.took_backend.global.security.jwt.TokenProvider;
import com.example.took_backend.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class  LogoutService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final BlackListRepository  blackListRepository;
    private final TokenProvider tokenProvider;
    private final JwtProperties jwtProperties;
    private final RedisTemplate redisTemplate;

    @Transactional
    public void execute(String accessToken){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        RefreshToken refreshToken = refreshTokenRepository.findRefreshTokenByEmail(email).orElseThrow(()->new RefreshTokenNotFoundException("리프레시 토큰을 찾을 수 없습니다."));
        refreshTokenRepository.delete(refreshToken);
        saveBlackList(email,accessToken);
    }
    private void saveBlackList(String email, String accessToken){
        if(redisTemplate.opsForValue().get(accessToken)!=null){
            throw new BlackListAlreadyExistException("블랙리스트에 이미 등록되어있습니다.");
        }
        Date accessTokenExpire = tokenProvider.getExpiredAtToken(accessToken,jwtProperties.getAccessSecret());
        BlackList blackList = BlackList.builder()
                .email(email)
                .accessToken(accessToken)
                .timeToLive(accessTokenExpire.getTime())
                .build();
        blackListRepository.save(blackList);

    }
}
