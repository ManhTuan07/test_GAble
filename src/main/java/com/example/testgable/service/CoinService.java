package com.example.testgable.service;

import com.example.testgable.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.List;

public interface CoinService {

    Page<CoinResponseDto> getCoinResponse (CoinRequestDto coinRequestDto, Pageable pageable);

    CoinDetailDto getSingleCoinDetail(String id);

}
