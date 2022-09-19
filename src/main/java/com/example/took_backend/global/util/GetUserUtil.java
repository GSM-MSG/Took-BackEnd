package com.example.took_backend.global.util;

import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserUtil {
    private final UserRepository userRepository;

    public User getUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUserByEmail(email).orElseThrow(()-> new UserNotFoundException("유저가 없습니다"));
    }
}
