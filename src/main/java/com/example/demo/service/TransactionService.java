package com.example.demo.service;

import com.example.demo.dto.TransactionDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    TransactionDto saveTransaction(TransactionDto transactionDto);

    List<TransactionDto> getLimitExceededTransactions(String accountNumber);
}
