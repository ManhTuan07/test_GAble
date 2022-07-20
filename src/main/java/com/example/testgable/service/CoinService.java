package com.example.testgable.service;

import com.example.testgable.dto.CoinDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CoinService {
    Page<Object> getCoins(String currency, Pageable pageable);
}
