package com.example.took_backend.domain.cardexhange;

import com.example.took_backend.domain.businesscard.BusinessCard;
import com.example.took_backend.domain.user.User;
import com.example.took_backend.global.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@IdClass(CardExchangeId.class)
public class CardExchange extends BaseTimeEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "businesscard_uuid")
    private BusinessCard businessCard;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "businesscard_user_uuid")
    private User businessUser;
}
