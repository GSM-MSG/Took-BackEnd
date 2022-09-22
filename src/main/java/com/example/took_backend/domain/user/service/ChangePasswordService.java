package com.example.took_backend.domain.user.service;

import com.example.took_backend.domain.auth.exception.NotVerifyEmailException;
import com.example.took_backend.domain.email.entity.EmailAuth;
import com.example.took_backend.domain.email.repository.EmailAuthRepository;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {
    private final UserUtil userUtil;
    private final PasswordEncoder passwordEncoder;
    private final EmailAuthRepository emailAuthRepository;

    @Transactional
    public void execute(ChangePasswordRequest changePasswordRequest){
        User user = userUtil.currentUser();
        if(validateAuthentication(user.getEmail())){
            user.updatePassword(passwordEncoder.encode(changePasswordRequest.getPassword()));
        }
    }
    private Boolean validateAuthentication(String email){
        System.out.println(email);
        EmailAuth emailAuth = emailAuthRepository.findById(email).orElseThrow(()->new UserNotFoundException("유저를 찾을 수 없습니다."));
        if (!emailAuth.getAuthentication()) {
            throw new NotVerifyEmailException("이메일이 인증되지 않았습니다");
        }
        return true;
    }
}
