package com.example.took_backend.domain.businesscard.entity;

import com.example.took_backend.domain.user.User;
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
public class BusinessCard extends BaseTimeEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARBINARY(36)")
    @Builder.Default
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "front_url")
    private String frontUrl;

    @Column(name = "back_url")
    private String backUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_uuid")
    private User user;

    @OneToMany(mappedBy = "businessCard")
    private List<CardExchange> cardExchanges = new ArrayList<>();
}
