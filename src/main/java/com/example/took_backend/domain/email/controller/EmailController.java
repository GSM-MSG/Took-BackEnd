package com.example.took_backend.domain.email.controller;

import com.example.took_backend.domain.email.presentation.dto.request.EmailSentDto;
import com.example.took_backend.domain.email.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("email")
public class EmailController {
    private final MailSenderService mailSenderService;
    @PostMapping
    public ResponseEntity<Void> authEmail(@RequestBody @Valid EmailSentDto emailSentDto){
        mailSenderService.execute(emailSentDto);
        return ResponseEntity.ok().build();
    }
}
