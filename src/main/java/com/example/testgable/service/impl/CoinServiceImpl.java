package com.example.testgable.service.impl;

import com.example.testgable.dto.*;
import com.example.testgable.service.CoinService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CoinServiceImpl implements CoinService {

    @Override
    public ResponseEntity<?> getCoin(CoinRequestDto coinRequestDto, Pageable pageable) {
        try {
            Map<String, String> uriVariable = new HashMap<>();
            uriVariable.put("vs_currency", coinRequestDto.getCurrency());
            RestTemplate coinMarketRestTemplate = new RestTemplate();
            CoinMarketDto[] coinMarket = coinMarketRestTemplate.getForObject(
                    "https://api.coingecko.com/api/v3/coins/markets?vs_currency={vs_currency}", CoinMarketDto[].class,
                    uriVariable);
            ResponseEntity<CoinResponseDto[]> getResponse = new RestTemplate().getForEntity(
                    "https://api.coingecko.com/api/v3/coins/markets?vs_currency={vs_currency}", CoinResponseDto[].class,
                    uriVariable);
            CoinResponseDto[] responseDtos = getResponse.getBody();
            List<CoinResponseDto> coinResponseDtos = Arrays.asList(responseDtos);
            List<CoinMarketDto> coinMarketDtos = Arrays.asList(coinMarket);
            final int start = (int) pageable.getOffset();
            final int end = Math.min((start + pageable.getPageSize()), coinResponseDtos.size());
            Page<CoinResponseDto> pages = new PageImpl<>(coinResponseDtos.subList(start, end), pageable, coinResponseDtos.size());
            for (int i = start; i < end; i++) {
                uriVariable.put("coin", coinMarketDtos.get(i).getId());
                ResponseEntity<CoinDetailDto> getcoindetail = new RestTemplate().getForEntity(
                        "https://api.coingecko.com/api/v3/coins/{coin}", CoinDetailDto.class, uriVariable);
                coinResponseDtos.get(i).setDescription(getcoindetail.getBody().getDescription().getEn());
                coinResponseDtos.get(i).setTradeUrl(getcoindetail.getBody().getTickers()[0].getTradeUrl());
            }

            return new ResponseEntity<>(pages, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Server is down", HttpStatus.NOT_FOUND);
        }

    }



}
