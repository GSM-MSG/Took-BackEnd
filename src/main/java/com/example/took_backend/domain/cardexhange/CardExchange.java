package com.example.took_backend.domain.cardexhange;

import com.example.took_backend.domain.businesscard.BusinessCard;
import com.example.took_backend.domain.user.User;

import javax.persistence.*;

@Entity
@IdClass(CardExchangeId.class)
public class CardExchange {
    @ManyToOne
    @JoinColumn(name = "businesscard_uuid")
    private BusinessCard businessCard;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "businesscard_user_uuid")
    private User businessUser;
}
