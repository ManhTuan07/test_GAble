package com.example.testgable.repository;

import com.example.testgable.entity.CoinPrice;
import com.example.testgable.entity.CoinPricePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinPriceRepository extends JpaRepository<CoinPrice, CoinPricePK> {
}