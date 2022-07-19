package com.example.testgable.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coin")
@Getter
@Setter
public class Coin {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String symbol;
    private String image;
    private String name;
    private Double priceChangePercentage24h;
    private String description;
    private String tradeUrl;
}
