package com.example.testgable.controller;

import com.example.testgable.dto.CoinDetailDto;
import com.example.testgable.dto.CoinMarketDto;
import com.example.testgable.dto.CoinRequestDto;
import com.example.testgable.dto.CoinResponseDto;
import com.example.testgable.service.impl.CoinServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
    public List<CoinResponseDto> getCoins(@RequestBody CoinRequestDto coinRequestDto) {
        List<CoinMarketDto> coinMarketDtos = coinService.getCoinMarket(coinRequestDto.getCurrency());
        return coinService.getCoinResponse(coinMarketDtos);
    }

    @GetMapping("getcoinsdetail/{id}")
    public CoinDetailDto getCoinsDetail (@PathVariable String id) {
        return coinService.getCoinDetail(id);
    }
}
