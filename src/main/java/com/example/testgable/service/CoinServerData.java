package com.example.testgable.service;

import java.util.List;

public interface CoinServerData {
    boolean isServerDown();
    List<String> getCurrencies();

}
