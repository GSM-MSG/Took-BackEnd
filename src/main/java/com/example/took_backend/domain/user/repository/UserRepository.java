package com.example.took_backend.domain.user.repository;

import com.example.took_backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);
}
