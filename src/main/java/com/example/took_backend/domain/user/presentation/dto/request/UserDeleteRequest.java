package com.example.took_backend.domain.user.presentation.dto.request;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserDeleteRequest {
    private String password;
}
