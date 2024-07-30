package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    @NotNull
    private String accountFrom;

    @NotNull
    private String accountTo;

    @NotNull
    private String currencyShortName;

    @NotNull
    private BigDecimal moneySum;

    @NotNull
    private ExpenseCategory expenseCategory;

    @NotNull
    private ZonedDateTime datetime;
}
