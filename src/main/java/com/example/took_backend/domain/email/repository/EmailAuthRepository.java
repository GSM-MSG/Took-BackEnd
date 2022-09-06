package com.example.took_backend.domain.email.repository;

import com.example.took_backend.domain.email.EmailAuthEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmailAuthRepository extends CrudRepository<EmailAuthEntity,String> {
}
