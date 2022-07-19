package com.example.testgable.repository;

import com.example.testgable.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<String, Coin> {
}
