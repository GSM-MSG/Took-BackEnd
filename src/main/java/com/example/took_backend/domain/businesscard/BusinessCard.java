package com.example.took_backend.domain.businesscard;

import com.example.took_backend.domain.businesscard.enumType.Distinguish;
import com.example.took_backend.domain.cardexhange.CardExchange;
import com.example.took_backend.domain.user.User;
import com.example.took_backend.global.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
public class BusinessCard extends BaseTimeEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARBINARY(36)")
    @Builder.Default
    private UUID uuid = UUID.randomUUID();

    private String url;

    // 명함 앞뒤 (Front , Back)
    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    private Distinguish distinguish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_uuid")
    private User user;

    @OneToMany(mappedBy = "businessCard")
    private List<CardExchange> cardExchanges = new ArrayList<>();
}
