package com.example.testgable.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinRequestDto {

    @NotNull(message = "Currency must have value")
    String currency;

    @Min(value = 1, message = "Page min value is 1")
    @Max(value = 100, message = "Page max value is 100")
    int page = 0;

    @Min(value = 1, message = "Per_page min value is 1")
    @Max(value = 250, message = "Per_page max value is 250")
    int perPage;

}