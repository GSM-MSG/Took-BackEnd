package com.example.took_backend.domain.auth.repository;

import com.example.took_backend.domain.auth.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList,String> {
}
