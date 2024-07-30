package com.example.demo.controller;

import com.example.demo.dto.TransactionDto;
import com.example.demo.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transaction", description = "The Transaction API")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Operation(
            summary = "Save transaction",
            description = "Save transaction as a `TransactionDto` object"
    )
    @PostMapping
    public TransactionDto saveTransaction(@RequestBody @Valid TransactionDto transactionDto) {
        return transactionService.saveTransaction(transactionDto);
    }

    @Operation(
            summary = "Get all limit exceeded transactions",
            description = "Get all limit exceeded transactions by account number"
    )
    @GetMapping("/{accountNumber}/exceeded")
    public List<TransactionDto> getLimitExceededTransactions(@PathVariable String accountNumber) {
        return transactionService.getLimitExceededTransactions(accountNumber);
    }
}
