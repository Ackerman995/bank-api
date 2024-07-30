package com.example.demo.controller;

import static org.mockito.Mockito.*;


import com.example.demo.dto.ExpenseCategory;
import com.example.demo.dto.MonthlyLimitDto;
import com.example.demo.service.MonthlyLimitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;


@ExtendWith(MockitoExtension.class)
public class MonthlyLimitControllerTest {
    @InjectMocks
    private MonthlyLimitController monthlyLimitController;
    @Mock
    private MonthlyLimitService monthlyLimitService;

    MonthlyLimitDto monthlyLimitDto;

    @BeforeEach
    void setUp() {
        monthlyLimitDto = MonthlyLimitDto.builder()
                .accountNumber("123123123")
                .expenseCategory(ExpenseCategory.valueOf("SERVICE"))
                .amount(BigDecimal.valueOf(1000))
                .currency("USD")
                .build();
    }

    @Test
    void testMonthlyLimitIsUpdated() {
        monthlyLimitController.updateMonthlyLimit(monthlyLimitDto);
        verify(monthlyLimitService, times(1)).updateMonthlyLimit(monthlyLimitDto);
    }

    @Test
    void testGetAllLimits() {
        monthlyLimitController.getAllLimits("123123123");
        verify(monthlyLimitService, times(1)).getAllLimits("123123123");
    }
}
