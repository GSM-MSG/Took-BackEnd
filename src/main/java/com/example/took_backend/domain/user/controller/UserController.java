package com.example.took_backend.domain.user.controller;

import com.example.took_backend.domain.user.presentation.dto.response.MyCardInfoDto;
import com.example.took_backend.domain.user.service.FindCardInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@Slf4j
public class UserController {
    private final FindCardInfoService findCardInfoService;

    @GetMapping
    public MyCardInfoDto getMyCardInfo(){
        return findCardInfoService.findCardInfo();
    }
}
