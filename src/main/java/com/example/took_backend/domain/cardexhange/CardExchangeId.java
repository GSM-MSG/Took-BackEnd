package com.example.took_backend.domain.cardexhange;

import com.example.took_backend.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class CardExchangeId implements Serializable {

    private User businessUser;
    private User user;

    
}
