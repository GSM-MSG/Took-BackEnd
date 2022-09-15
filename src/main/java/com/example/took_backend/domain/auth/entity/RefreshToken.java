package com.example.took_backend.domain.auth.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "refreshToken",timeToLive = 3000* 24 * 30 * 6)
public class RefreshToken {
    @Id
    private String email;
    private String refreshToken;

    public void deleteRefreshToken(){
        this.refreshToken = null;
    }
}
