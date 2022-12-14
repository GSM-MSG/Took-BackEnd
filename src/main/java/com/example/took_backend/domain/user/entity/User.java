package com.example.took_backend.domain.user.entity;


import com.example.took_backend.domain.business_card.entity.BusinessCard;
import com.example.took_backend.domain.business_card.entity.CardExchange;
import com.example.took_backend.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Builder.Default
    private String uuid = UUID.randomUUID().toString();

    private String email;

    @Column(length = 60)
    private String password;

    @OneToMany(mappedBy = "uuid",cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<BusinessCard> businessCard = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @Builder.Default
    private List<CardExchange> cardExchanges = new ArrayList<>();

    public void updatePassword(String password){
        this.password = password;
    }
}
