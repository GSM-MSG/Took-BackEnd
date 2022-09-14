package com.example.took_backend.domain.email.repository;

import com.example.took_backend.domain.email.entity.EmailAuth;
import org.springframework.data.repository.CrudRepository;

public interface EmailAuthRepository extends CrudRepository<EmailAuth,String> {
}
