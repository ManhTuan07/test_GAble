package com.example.testgable.service.impl;

import com.example.testgable.dto.CoinDetailDto;
import com.example.testgable.dto.CoinMarketDto;
import com.example.testgable.service.CoinService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {


    @Override
    public CoinDetailDto getCoinDetail(String id) {
        String coinDetailUri = "https://api.coingecko.com/api/v3/coins/";
        RestTemplate coinDetailRestTemplate = new RestTemplate();
        CoinDetailDto coinDetailDto = coinDetailRestTemplate.getForObject(coinDetailUri+id, CoinDetailDto.class);
        return coinDetailDto;
    }

    @Override
    public List<CoinMarketDto> getCoinMarket(String currency) {
        String coinMarketUri = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=";
        RestTemplate coinMarketRestTemplate = new RestTemplate();
        CoinMarketDto[] coinMarketDtos = coinMarketRestTemplate.getForObject(coinMarketUri+currency, CoinMarketDto[].class);
        return Arrays.asList(coinMarketDtos);
    }
}
