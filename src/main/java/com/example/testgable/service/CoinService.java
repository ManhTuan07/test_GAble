package com.example.testgable.service;

import com.example.testgable.dto.CoinDetailDto;
import com.example.testgable.dto.CoinMarketDto;
import com.example.testgable.dto.CoinResponseDto;

import java.util.List;

public interface CoinService {
    List<CoinDetailDto> getCoinDetail(List<CoinMarketDto> coinMarketDtos);
    List<CoinMarketDto> getCoinMarket(String currency);
    List<CoinResponseDto> getCoinResponse (List<CoinMarketDto> coinMarketDtos);

    CoinDetailDto getSingleCoinDetail(String id);

}
