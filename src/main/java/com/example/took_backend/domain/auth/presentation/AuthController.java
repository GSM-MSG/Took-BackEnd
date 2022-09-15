package com.example.took_backend.domain.auth.presentation;

import com.example.took_backend.domain.auth.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final LogoutService logoutService;

    @DeleteMapping
    public ResponseEntity<Void>logout(){
        logoutService.execute();
        return ResponseEntity.ok().build();
    }
}
