package com.example.took_backend.domain.email.service;

import com.example.took_backend.domain.email.exception.AuthCodeExpiredException;
import com.example.took_backend.domain.email.repository.EmailAuthRepository;
import com.example.took_backend.domain.email.entity.EmailAuth;
import com.example.took_backend.domain.email.exception.ManyRequestEmailAuthException;
import com.example.took_backend.domain.email.presentation.dto.request.EmailSentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;


@Service
@EnableAsync
@RequiredArgsConstructor
public class MailSenderService {
    private final JavaMailSender mailSender;
    private final EmailAuthRepository emailAuthRepository;

    @Async
    @Transactional(rollbackFor = Exception.class)
    public void execute(EmailSentDto emailSentDto){

        Random random = new Random();
        String authKey = String.valueOf(random.nextInt(8888) + 1111);

        sendAuthEmail(emailSentDto.getEmail(),authKey);
    }

    private void sendAuthEmail(String email, String authKey) {
        String subject = "TOOK 인증번호";
        String text = "회원 가입을 위한 인증번호는 " + authKey + "입니다. <br />";
        EmailAuth emailAuthEntity = emailAuthRepository.findById(email)
                .orElse(EmailAuth.builder()
                        .authentication(false)
                        .randomValue(authKey)
                        .attemptCount(0)
                        .email(email)
                        .build());
        if (emailAuthEntity.getAttemptCount() >= 3) {
            throw new ManyRequestEmailAuthException("발송 횟수 초과");
        }
        emailAuthEntity.updateRandomValue(authKey);
        emailAuthEntity.increaseAttemptCount();


        emailAuthRepository.save(emailAuthEntity);
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text,true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new AuthCodeExpiredException("메일 발송에 실패했습니다");
        }
    }

}
