package com.example.took_backend.domain.auth.controller;

import com.example.took_backend.domain.auth.dto.request.UserSignInRequest;
import com.example.took_backend.domain.auth.dto.request.UserSignUpRequest;
import com.example.took_backend.domain.auth.dto.response.UserSignInResponse;
import com.example.took_backend.domain.auth.service.SignInService;
import com.example.took_backend.domain.auth.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignupService signupService;
    private final SignInService signInService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody UserSignUpRequest userReq) {
        signupService.execute(userReq);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<UserSignInResponse> signIn(@RequestBody UserSignInRequest userReq) {
        UserSignInResponse data = signInService.signIn(userReq);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
