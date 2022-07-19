package com.example.testgable.mapper;

import com.example.testgable.dto.CoinDto;
import com.example.testgable.entity.Coin;
import com.example.testgable.entity.Currency;
import org.mapstruct.*;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CoinResponseDtoMapper {
    @Mapping(source = "priceChangePercentage24h", target = "priceChangePercentage24h", numberFormat = "#.##")
    Coin toEntity(CoinDto dto);


    @Mapping(source = "coin.priceChangePercentage24h", target = "priceChangePercentage24h", numberFormat = "#.##")
    @Mapping(source = "coin.coinPrices", target = "currentPrice", numberFormat = "#.##")
    CoinDto toDto(Coin coin, @Context Currency currency);

    default BigDecimal map(List<CoinPrice> coinPriceList, @Context Currency currency) {
        return coinPriceList != null && !coinPriceList.isEmpty() ?
                coinPriceList.stream().filter(coinPrice -> ObjectUtils.nullSafeEquals(coinPrice.getCurrency(), currency))
                        .findAny().orElse(new CoinPrice())
                        .getCurrentPrice() : BigDecimal.ZERO;
    }

    List<CoinDto> toDtoList(List<Coin> coinList, @Context Currency currency);
}
