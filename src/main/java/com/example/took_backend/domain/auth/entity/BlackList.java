package com.example.took_backend.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash()
public class BlackList {
    @Id
    private String accessToken;
    private String email;
    @TimeToLive
    private ZonedDateTime timeToLive;
}
