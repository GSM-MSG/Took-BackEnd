package com.example.took_backend.domain.cardexhange.repository;

import com.example.took_backend.domain.cardexhange.CardExchange;
import com.example.took_backend.domain.cardexhange.CardExchangeId;
import com.example.took_backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardExchangeRepository extends JpaRepository<CardExchange,CardExchangeId> {
    List<CardExchange> findAllByUser(User user);
}
