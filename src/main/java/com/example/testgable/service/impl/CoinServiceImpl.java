package com.example.testgable.service.impl;

import com.example.testgable.dto.CoinDto;
import com.example.testgable.service.CoinService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {

    @Override
    public List<CoinDto> getCoins(CoinDto requestDto) {
        return null;
    }
}
