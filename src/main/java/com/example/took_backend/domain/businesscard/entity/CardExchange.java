package com.example.took_backend.domain.businesscard.entity;

import com.example.took_backend.domain.businesscard.entity.BusinessCard;
import com.example.took_backend.domain.businesscard.entity.CardExchangeId;
import com.example.took_backend.domain.user.User;
import com.example.took_backend.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
