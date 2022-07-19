package com.example.testgable.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@ConfigurationProperties(prefix = "coin.server")
public class ApiConfig {
    private String api;
    private String ping;
    private String coinsList;
    private String coinsMarkets;
    private String coinsId;
    private String supportedCurrencies;
}

