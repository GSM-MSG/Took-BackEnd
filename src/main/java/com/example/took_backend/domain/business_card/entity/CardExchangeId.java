package com.example.took_backend.domain.business_card.entity;

import com.example.took_backend.domain.user.entity.User;
import lombok.*;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CardExchangeId implements Serializable {

    private String businessCard;
    private String user;
}
