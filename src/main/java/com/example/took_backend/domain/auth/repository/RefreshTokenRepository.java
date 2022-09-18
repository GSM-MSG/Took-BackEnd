package com.example.took_backend.domain.auth.repository;

import com.example.took_backend.domain.auth.RefreshTokenAuthEntity;
import org.springframework.data.repository.CrudRepository;


public interface RefreshTokenRepository extends CrudRepository<RefreshTokenAuthEntity, String> {

}