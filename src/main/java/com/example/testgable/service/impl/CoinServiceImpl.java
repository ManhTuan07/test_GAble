package com.example.testgable.service.impl;

import com.example.testgable.dto.CoinDetailDto;
import com.example.testgable.dto.CoinMarketDto;
import com.example.testgable.dto.CoinResponseDto;
import com.example.testgable.service.CoinService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {
    List<CoinResponseDto> coinResponseDtoList = new ArrayList<>();

    @Override
    public CoinDetailDto getCoinDetail(String id) {
        String coinDetailUrl = "https://api.coingecko.com/api/v3/coins/";
        RestTemplate coinDetailRestTemplate = new RestTemplate();
        CoinDetailDto coinDetailDto = coinDetailRestTemplate.getForObject(coinDetailUrl+id, CoinDetailDto.class);
        return coinDetailDto;
    }

    @Override
    public List<CoinMarketDto> getCoinMarket(String currency) {
        String coinMarketUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=";
        RestTemplate coinMarketRestTemplate = new RestTemplate();
        CoinMarketDto[] coinMarketDtos = coinMarketRestTemplate.getForObject(coinMarketUrl+currency, CoinMarketDto[].class);
        return Arrays.asList(coinMarketDtos);
    }

    @Override
    public List<CoinResponseDto> getCoinResponse(List<CoinMarketDto> coinMarketDtos) {
        for (CoinMarketDto coinMarket: coinMarketDtos) {
            CoinResponseDto coinResponseDto = new CoinResponseDto();
            CoinDetailDto coinDetailDto = getCoinDetail(coinMarket.getId());
            coinResponseDto.setImage(coinMarket.getImage());
            coinResponseDto.setName(coinMarket.getName());
            coinResponseDto.setSymbol(coinMarket.getSymbol());
            coinResponseDto.setPriceChangePercentage24h(coinMarket.getPriceChangePercentage24h());
            coinResponseDto.setDescription(coinDetailDto.getDescription().getEn());
            coinResponseDto.setTradeUrl(coinDetailDto.getTickers().get(0).getTradeUrl());
            coinResponseDto.setCurrentPrice(coinDetailDto.getCurrentPrice());
            coinResponseDtoList.add(coinResponseDto);
        }
        return coinResponseDtoList;
    }

}
