package com.example.took_backend.domain.auth.repository;

import com.example.took_backend.domain.auth.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
