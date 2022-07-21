package com.example.testgable.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CoinDetailDto {
    DescriptionDto description;
    List<TickerDto> tickers;
}
