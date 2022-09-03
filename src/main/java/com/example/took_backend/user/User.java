package com.example.took_backend.user;

import com.example.took_backend.businesscard.BusinessCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    @Builder.Default
    private UUID uuid = UUID.randomUUID();

    private String email;

    private String password;

    @CreatedDate
    @Column(name = "creadtd_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "uuid")
    private List<BusinessCard> businessCard = new ArrayList<>();
}
