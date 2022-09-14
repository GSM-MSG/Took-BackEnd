package com.example.took_backend.domain.business_card.repository;


import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessCardRepository extends JpaRepository<BusinessCard, String> {
    Optional<BusinessCard> findBusinessCardByUser(User user);
}
