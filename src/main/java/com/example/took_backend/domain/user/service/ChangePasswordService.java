package com.example.took_backend.domain.user.service;

import com.example.took_backend.domain.auth.exception.NotVerifyEmailException;
import com.example.took_backend.domain.email.entity.EmailAuth;
import com.example.took_backend.domain.email.repository.EmailAuthRepository;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.example.took_backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailAuthRepository emailAuthRepository;

    @Transactional
    public void execute(ChangePasswordRequest changePasswordRequest){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User userInfo = userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFoundException("유저를 찾을 수 없습니다."));
        if(validateAuthentication(email)){
            userInfo.update(passwordEncoder.encode(changePasswordRequest.getPassword()));
        }
    }
    private Boolean validateAuthentication(String email){
        EmailAuth emailAuth = emailAuthRepository.findById(email).orElseThrow(()->new UserNotFoundException("유저를 찾을 수 없습니다."));
        if (emailAuth.getAuthentication() != false) {
            return true;
        }
        throw new NotVerifyEmailException("이메일이 인증되지 않았습니다");
    }
}
