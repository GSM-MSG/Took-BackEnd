package com.example.took_backend.domain.user.presentation;

import com.example.took_backend.domain.user.presentation.dto.response.MyCardInfoResponse;
import com.example.took_backend.domain.user.service.FindCardInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final FindCardInfoService findCardInfoService;

    @GetMapping
    public MyCardInfoResponse getMyCardInfo(){
        return findCardInfoService.findCardInfo();
    }
}
