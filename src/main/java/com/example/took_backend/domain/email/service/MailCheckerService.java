package com.example.took_backend.domain.email.service;

import com.example.took_backend.domain.email.EmailAuthEntity;
import com.example.took_backend.domain.email.exception.AuthCodeMismatchException;
import com.example.took_backend.domain.email.repository.EmailAuthRepository;
import com.example.took_backend.global.exception.exceptionCollection.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MailCheckerService {
    private final EmailAuthRepository emailAuthRepository;

    @Transactional
    public void execute(String email,String authKey){
        EmailAuthEntity emailAuthEntity = emailAuthRepository.findById(email).orElseThrow(()->new UserNotFoundException("유저를 찾을 수 없습니다."));
        checkAuthKey(emailAuthEntity,authKey);
        emailAuthEntity.updateAuthentication(true);
        emailAuthRepository.save(emailAuthEntity);
    }
    private void checkAuthKey(EmailAuthEntity emailAuthEntity,String authKey){
        if(!Objects.equals(emailAuthEntity.getRandomValue(), authKey)){
            throw new AuthCodeMismatchException("인증번호가 일치하지 않습니다.");
        }
    }
}
