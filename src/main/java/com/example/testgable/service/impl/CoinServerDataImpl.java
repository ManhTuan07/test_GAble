package com.example.testgable.service.impl;

import com.example.testgable.service.CoinServerData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinServerDataImpl implements CoinServerData {

    @Value("${coin.server.ping}")
    private String userBucketPath;

    @Override
    public boolean isServerDown() {
        return false;
    }

    @Override
    public List<String> getCurrencies() {
        return null;
    }

    public String print(){
        return userBucketPath;
    }
}
