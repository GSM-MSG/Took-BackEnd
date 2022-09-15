package com.example.took_backend.domain.auth.service;

import com.example.took_backend.domain.auth.dto.request.UserSignUpRequest;
import com.example.took_backend.domain.auth.exception.EmailAlreadyExistException;
import com.example.took_backend.domain.auth.exception.NotVerifyEmailException;
import com.example.took_backend.domain.email.entity.EmailAuth;
import com.example.took_backend.domain.email.repository.EmailAuthRepository;

import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final EmailAuthRepository emailAuthRepository;
    private final PasswordEncoder passwordEncoder;
    public void execute(UserSignUpRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistException("이메일이 이미 DB에 존재 합니다.");
        }
        EmailAuth emailAuth = emailAuthRepository.findById(request.getEmail())
                .orElseThrow(() -> new NotVerifyEmailException("이메일이 인증되지 않았습니다."));
        if(!emailAuth.getAuthentication()) {
            throw new NotVerifyEmailException("이메일이 인증되지 않았습니다");
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }
}
