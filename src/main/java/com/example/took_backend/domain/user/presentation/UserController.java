package com.example.took_backend.domain.user.presentation;

import com.example.took_backend.domain.user.presentation.dto.response.MyCardInfoResponse;
import com.example.took_backend.domain.user.service.FindCardInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final FindCardInfoService findCardInfoService;

    @GetMapping
    public ResponseEntity<MyCardInfoResponse> getMyCardInfo(){
        return new ResponseEntity<>(findCardInfoService.findCardInfo(), HttpStatus.OK);
    }
}
