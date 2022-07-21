package com.example.testgable.controller;

import com.example.testgable.dto.*;
import com.example.testgable.service.impl.CoinServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coins")
@RequiredArgsConstructor
@Tag(name = "Coin Controller", description = "Coins-related functions")
public class CoinController {
    private final CoinServiceImpl coinService;
    @Operation(summary = "Get Coins data from Coin Server")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coins Data are found"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Server internal error")
    })
    @GetMapping("getcoins")
    public Page<CoinResponseDto> getCoins(@RequestBody CoinRequestDto coinRequestDto, Pageable pageable) {
        pageable = PageRequest.of(coinRequestDto.getPage(),coinRequestDto.getPerPage());
        return coinService.getCoinResponse(coinRequestDto, pageable);
    }

    @GetMapping("getcoinsdetail/{id}")
    public CoinDetailDto getCoinsDetail (@PathVariable String id) {
        return coinService.getSingleCoinDetail(id);
    }
    
}
