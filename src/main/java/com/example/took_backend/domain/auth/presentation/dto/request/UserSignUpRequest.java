package com.example.took_backend.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequest {
    @NotBlank(message = "이메일(필수)")
    private String email;
    @NotBlank(message = "비밀번호(필수)")
    private String password;
}
