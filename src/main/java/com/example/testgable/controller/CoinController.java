package com.example.testgable.controller;

import com.example.testgable.dto.CoinDetailDto;
import com.example.testgable.dto.CoinMarketDto;
import com.example.testgable.dto.CoinResponseDto;
import com.example.testgable.service.impl.CoinServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coins")
@RequiredArgsConstructor
@Tag(name = "Coin Controller", description = "Coins-related functions")
public class CoinController {
    private final CoinServiceImpl coinService;
    List<CoinResponseDto> coinResponseDtoList = new ArrayList<>();
    @Operation(summary = "Get Coins data from Coin Server")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coins Data are found"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Server internal error")
    })
    @GetMapping("getcoins/{currency}")
    public List<CoinResponseDto> getCoins(@PathVariable String currency) {
        List<CoinMarketDto> coinMarketDtos = coinService.getCoinMarket(currency);
        for (CoinMarketDto coinMarket: coinMarketDtos) {
            CoinResponseDto coinResponseDto = new CoinResponseDto();
            CoinDetailDto coinDetailDto = coinService.getCoinDetail(coinMarket.getId());
            coinResponseDto.setImage(coinMarket.getImage());
            coinResponseDto.setName(coinMarket.getName());
            coinResponseDto.setSymbol(coinMarket.getSymbol());
            coinResponseDto.setPriceChangePercentage24h(coinMarket.getPriceChangePercentage24h());
            coinResponseDto.setDescription(coinDetailDto.getDescription());
            coinResponseDto.setTradeUrl(coinDetailDto.getTickers());
            coinResponseDto.setCurrentPrice(coinDetailDto.getCurrentPrice());
            coinResponseDtoList.add(coinResponseDto);
        }
        return coinResponseDtoList;
    }


}
