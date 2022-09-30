package com.example.took_backend.domain.business_card.entity;

import com.example.took_backend.domain.user.entity.User;
import com.example.took_backend.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@IdClass(CardExchangeId.class)
public class CardExchange extends BaseTimeEntity implements Serializable {
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
