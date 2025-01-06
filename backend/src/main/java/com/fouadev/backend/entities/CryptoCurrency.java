package com.fouadev.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CryptoCurrency {
    @Id
    private String id;
    private String name;
    private String type;
    private String unit;
    private double emission;
    private String consensusRule;
    private String algorithm;
    private String protocol;
    private String platform;
    private String webSite;
    private String community;
}