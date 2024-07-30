package com.example.demo.controller;

import static org.mockito.Mockito.*;

import com.example.demo.dto.ExpenseCategory;
import com.example.demo.dto.TransactionDto;
import com.example.demo.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;
    @Mock
    private TransactionService transactionService;
    TransactionDto transactionDto;

    @BeforeEach
    void setUp() {
        transactionDto = TransactionDto.builder()
                .accountFrom("123123123")
                .accountTo("234234234")
                .currencyShortName("USD")
                .datetime(ZonedDateTime.now())
                .expenseCategory(ExpenseCategory.valueOf("SERVICE"))
                .moneySum(BigDecimal.ONE)
                .build();
    }

    @Test
    void testTransactionIsSaved() {
        transactionController.saveTransaction(transactionDto);
        verify(transactionService, times(1)).saveTransaction(transactionDto);
    }

    @Test
    void testGetLimitExceededTransactions() {
        transactionController.getLimitExceededTransactions("123123123");
        verify(transactionService, times(1)).getLimitExceededTransactions("123123123");
    }
}
