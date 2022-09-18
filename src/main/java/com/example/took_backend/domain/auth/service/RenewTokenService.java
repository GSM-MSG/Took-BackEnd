package com.example.took_backend.domain.auth.service;

import com.example.took_backend.domain.auth.RefreshTokenAuthEntity;
import com.example.took_backend.domain.auth.dto.response.NewTokenResponse;
import com.example.took_backend.domain.auth.exception.TokenNotFoundException;
import com.example.took_backend.domain.auth.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RenewTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public NewTokenResponse tokenReissuance(String reqToken) {
        RefreshTokenAuthEntity token = refreshTokenRepository.findById(reqToken).orElseThrow(() -> new TokenNotFoundException("토큰이 존재하지 없습니다."));
    }
}
