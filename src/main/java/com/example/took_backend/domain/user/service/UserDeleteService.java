package com.example.took_backend.domain.user.service;

import com.example.took_backend.domain.auth.exception.PasswordWrongExceptin;
import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.presentation.dto.request.UserDeleteRequest;
import com.example.took_backend.domain.user.repository.UserRepository;
import com.example.took_backend.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;

    @Transactional
    public void execute(UserDeleteRequest userDeleteRequest){
        User user = userUtil.currentUser();
        if(!passwordEncoder.matches(userDeleteRequest.getPassword(), user.getPassword())) {
            throw new PasswordWrongExceptin("비밀번호가 올바르지 않습니다.");
        }
        userRepository.delete(user);
    }
}
