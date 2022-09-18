package com.example.took_backend.domain.auth.service;

import com.example.took_backend.domain.auth.entity.RefreshToken;
import com.example.took_backend.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.took_backend.domain.auth.presentation.dto.response.UserSignInResponse;
import com.example.took_backend.domain.auth.exception.PasswordWrongExceptin;
import com.example.took_backend.domain.auth.repository.RefreshTokenRepository;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.domain.user.repository.UserRepository;
import com.example.took_backend.global.security.jwt.TokenProvider;
import com.example.took_backend.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserSignInResponse signIn(UserSignInRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException("유저를 찾지 못했습니다."));
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new PasswordWrongExceptin("비밀번호가 올바르지 않습니다.");
        }
        String accessToken = tokenProvider.generatedAccessToken(request.getEmail());
        String refreshToken = tokenProvider.generatedRefreshToken(request.getEmail());
        RefreshToken entityToRedis = new RefreshToken(refreshToken, request.getEmail(), tokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());
        refreshTokenRepository.save(entityToRedis);
        return UserSignInResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(tokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret()))
                .build();
    }
}
