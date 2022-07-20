package com.example.testgable.service;

import com.example.testgable.dto.CoinDetailDto;
import com.example.testgable.dto.CoinMarketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoinService {
    CoinDetailDto getCoinDetail(String id);
    List<CoinMarketDto> getCoinMarket(String currency);
}
