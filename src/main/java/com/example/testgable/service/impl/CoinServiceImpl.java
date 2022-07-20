package com.example.testgable.service.impl;

import com.example.testgable.dto.CoinDto;
import com.example.testgable.service.CoinService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinServiceImpl implements CoinService {

    @Override
    public Page<Object> getCoins(String currency, Pageable pageable) {
       return null;
    }
}
