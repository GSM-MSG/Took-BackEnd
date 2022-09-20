package com.example.took_backend.domain.user.presentation;

import com.example.took_backend.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.example.took_backend.domain.user.presentation.dto.request.UserDeleteRequest;
import com.example.took_backend.domain.user.presentation.dto.response.MyCardInfoResponse;
import com.example.took_backend.domain.user.service.ChangePasswordService;
import com.example.took_backend.domain.user.service.FindCardInfoService;
import com.example.took_backend.domain.user.service.UserDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final FindCardInfoService findCardInfoService;
    private final ChangePasswordService changePasswordService;
    private final UserDeleteService userDeleteService;

    @GetMapping
    public ResponseEntity<MyCardInfoResponse> getMyCardInfo(){
        return new ResponseEntity<>(findCardInfoService.findCardInfo(), HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Void> changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest){
        changePasswordService.execute(changePasswordRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "password") UserDeleteRequest userDeleteRequest){
        userDeleteService.execute(userDeleteRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
