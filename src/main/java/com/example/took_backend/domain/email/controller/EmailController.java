package com.example.took_backend.domain.email.controller;

import com.example.took_backend.domain.email.presentation.dto.request.EmailSentDto;
import com.example.took_backend.domain.email.service.MailCheckerService;
import com.example.took_backend.domain.email.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
@RequestMapping("email")
public class EmailController {
    private final MailSenderService mailSenderService;
    private final MailCheckerService mailCheckerService;
    @PostMapping
    public ResponseEntity<Void> authEmail(@RequestBody @Valid EmailSentDto emailSentDto) {
        mailSenderService.execute(emailSentDto);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Void> mailVerify(@Email @RequestParam String email, @RequestParam String authKey){
        mailCheckerService.execute(email,authKey);
        return ResponseEntity.ok().build();
    }
}
