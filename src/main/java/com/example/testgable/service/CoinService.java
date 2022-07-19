package com.example.testgable.service;

import com.example.testgable.dto.CoinDto;

import java.util.List;

public interface CoinService {
    List<CoinDto> getCoins(CoinDto requestDto);
}
