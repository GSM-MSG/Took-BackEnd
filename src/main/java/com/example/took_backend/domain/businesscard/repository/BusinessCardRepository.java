package com.example.took_backend.domain.businesscard.repository;


import com.example.took_backend.domain.businesscard.entity.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCardRepository extends JpaRepository<BusinessCard, String> {
}
