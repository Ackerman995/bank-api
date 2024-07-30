package com.example.demo.service;

import com.example.demo.dto.ExpenseCategory;
import com.example.demo.dto.MonthlyLimitDto;
import com.example.demo.entity.MonthlyLimit;
import com.example.demo.entity.Transaction;

import java.util.List;

public interface MonthlyLimitService {
    boolean isMonthlyLimitExceeded(Transaction transaction);

    MonthlyLimitDto updateMonthlyLimit(MonthlyLimitDto monthlyLimitDto);

    List<MonthlyLimitDto> getAllLimits(String accountNumber);

    MonthlyLimit getLimit(String accountNumber, ExpenseCategory expenseCategory);
}
