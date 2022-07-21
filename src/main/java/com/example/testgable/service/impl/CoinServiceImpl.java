package com.example.testgable.service.impl;

import com.example.testgable.configuration.ApiConfig;
import com.example.testgable.dto.*;
import com.example.testgable.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private final ApiConfig apiConfig = new ApiConfig();

    @Override
    public Page<CoinResponseDto> getCoinResponse(CoinRequestDto coinRequestDto, Pageable pageable) {
        List<CoinResponseDto> coinResponseDtoList = new ArrayList<>();
        String coinMarketUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=";
        RestTemplate coinMarketRestTemplate = new RestTemplate();
        CoinMarketDto[] coinMarketDtos = coinMarketRestTemplate.getForObject(coinMarketUrl+coinRequestDto.getCurrency(), CoinMarketDto[].class);
        int count = 0;
        for (CoinMarketDto coinMarket: coinMarketDtos) {
            CoinDetailDto coinDetailDto = getSingleCoinDetail(coinMarket.getId());
            CoinResponseDto coinResponseDto = new CoinResponseDto();
            coinResponseDto.setImage(coinMarket.getImage());
            coinResponseDto.setName(coinMarket.getName());
            coinResponseDto.setSymbol(coinMarket.getSymbol());
            coinResponseDto.setPriceChangePercentage24h(coinMarket.getPriceChangePercentage24h());
            coinResponseDto.setCurrentPrice(coinMarket.getCurrentPrice());
            coinResponseDto.setDescription(coinDetailDto.getDescription().getEn());
            coinResponseDto.setTradeUrl(coinDetailDto.getTickers().get(0).getTradeUrl());
            coinResponseDtoList.add(coinResponseDto);
            count ++;
            if(count == coinRequestDto.getPerPage()){
                break;
            }
        }

        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), coinResponseDtoList.size());
        final Page<CoinResponseDto> page = new PageImpl<>(coinResponseDtoList.subList(start, end), pageable, coinResponseDtoList.size());
        return page;
    }

    @Override
    public CoinDetailDto getSingleCoinDetail(String id) {
        String coinDetailUrl = "https://api.coingecko.com/api/v3/coins/";
        RestTemplate coinDetailRestTemplate = new RestTemplate();
        CoinDetailDto coinDetailDto = coinDetailRestTemplate.getForObject(coinDetailUrl+id, CoinDetailDto.class);
        return coinDetailDto;
    }




}
