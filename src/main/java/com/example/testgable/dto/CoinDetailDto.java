package com.example.testgable.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CoinDetailDto {
    String id;
    String name;
    String symbol;
    @JsonProperty("price_change_percentage_24h")
    Double priceChangePercentage24h;
    BigDecimal currentPrice;
    DescriptionDto description;
    List<TickerDto> tickers;
}
