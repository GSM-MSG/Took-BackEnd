package com.example.took_backend.domain.business_card.repository;

import com.example.took_backend.domain.business_card.entity.CardExchange;
import com.example.took_backend.domain.business_card.entity.CardExchangeId;
import com.example.took_backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardExchangeRepository extends JpaRepository<CardExchange,CardExchangeId> {
    List<CardExchange> findAllByUser(User user);
}
