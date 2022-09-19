package com.example.took_backend.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RedisHash(value = "refreshToken")
public class RefreshTokenAuthEntity {
    @Id
    private String email;

    @Indexed
    private String token;

    @TimeToLive
    private long expiredAt;

    public void exchangeRefreshToken(String token) {
        this.token = token;
    }
}
