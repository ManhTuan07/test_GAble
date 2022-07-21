package com.example.testgable.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({ "image", "symbol", "name", "price_change_percentage_24h", "current_price", "description", "trade_url" })
public class CoinResponseDto {
    private String image;

    private String symbol;

    private String name;

    @JsonProperty("price_change_percentage_24h")
    private Double priceChangePercentage24h;

    @JsonProperty("current_price")
    private BigDecimal currentPrice;

    private String description;

    private String tradeUrl;
}
