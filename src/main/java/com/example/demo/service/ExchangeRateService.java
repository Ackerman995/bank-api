package com.example.demo.service;

import com.example.demo.entity.ExchangeRate;

import java.time.LocalDateTime;

public interface ExchangeRateService {
    ExchangeRate updateExchangeRate(String fromCurrency, String toCurrency, LocalDateTime exchangeDate);

    ExchangeRate getExchangeRate(String sourceCurrency, String targetCurrency, LocalDateTime exchangeDate);
}
