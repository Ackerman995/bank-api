package com.example.demo.controller;

import com.example.demo.dto.MonthlyLimitDto;
import com.example.demo.service.MonthlyLimitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Monthly Limit", description = "The MonthlyLimit API")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/limits")
public class MonthlyLimitController {
    private final MonthlyLimitService monthlyLimitService;

    @Operation(
            summary = "Update Monthly Limit",
            description = "Setting monthly limit by object of MonthlyLimitDto"
    )
    @PutMapping
    public MonthlyLimitDto updateMonthlyLimit(@RequestBody @Valid MonthlyLimitDto monthlyLimitDto) {
        return monthlyLimitService.updateMonthlyLimit(monthlyLimitDto);
    }

    @Operation(
            summary = "Get All Monthly Limit",
            description = "Get all monthly limit by account number"
    )
    @GetMapping("/{accountNumber}")
    public List<MonthlyLimitDto> getAllLimits(@PathVariable String accountNumber) {
        return monthlyLimitService.getAllLimits(accountNumber);
    }
}
