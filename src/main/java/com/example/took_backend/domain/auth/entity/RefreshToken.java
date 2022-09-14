package com.example.took_backend.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@RedisHash(value = "refreshToken",timeToLive = 3000* 24 * 30 * 6)
public class RefreshToken {
    @Id
    private String email;
    private String token;
}
