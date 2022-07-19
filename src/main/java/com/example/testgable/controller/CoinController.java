package com.example.testgable.controller;

import com.example.testgable.dto.CoinDto;
import com.example.testgable.service.CoinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/coins")
@RequiredArgsConstructor
@Tag(name = "Coin Controller", description = "Coins-related functions")
public class CoinController {
    private final CoinService coinService;

    @Operation(summary = "Get Coins data from Coin Server")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coins Data are found"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Server internal error")
    })
    @GetMapping("getcoins")
    public ResponseEntity<?> getCoins(@Valid @RequestBody CoinDto requestDto) {
        return ResponseEntity.ok(coinService.getCoins(requestDto));
    }
}
