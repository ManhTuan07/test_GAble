package com.example.testgable.service;

import com.example.testgable.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface CoinService {

    ResponseEntity<?> getCoin(CoinRequestDto coinRequestDto, Pageable pageable);

}
