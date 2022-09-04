package com.example.took_backend.domain.user;

import com.example.took_backend.domain.businesscard.BusinessCard;
import com.example.took_backend.domain.cardexhange.CardExchange;
import com.example.took_backend.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(columnDefinition = "VARBINARY(36)")
    @Builder.Default
    private UUID uuid = UUID.randomUUID();

    private String email;

    private String password;

    @OneToMany(mappedBy = "uuid")
    private List<BusinessCard> businessCard = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CardExchange> cardExchanges = new ArrayList<>();
}
