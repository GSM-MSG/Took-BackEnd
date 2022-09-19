package com.example.took_backend.domain.auth.presentation;

import com.example.took_backend.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.took_backend.domain.auth.presentation.dto.request.UserSignUpRequest;
import com.example.took_backend.domain.auth.presentation.dto.response.NewTokenResponse;
import com.example.took_backend.domain.auth.presentation.dto.response.UserSignInResponse;
import com.example.took_backend.domain.auth.service.LogoutService;
import com.example.took_backend.domain.auth.service.RenewTokenService;
import com.example.took_backend.domain.auth.service.SignInService;
import com.example.took_backend.domain.auth.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {
    private final LogoutService logoutService;
    private final SignupService signupService;
    private final SignInService signInService;
    private final RenewTokenService renewTokenService;


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

    @PatchMapping
    public ResponseEntity<NewTokenResponse> reIssueToken(@RequestHeader("RefreshToken") String token) {
        NewTokenResponse reIssueToken = renewTokenService.tokenReissuance(token);
        return new ResponseEntity<>(reIssueToken, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> logout(@RequestHeader("Authorization")String accessToken){
        logoutService.execute(accessToken);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
