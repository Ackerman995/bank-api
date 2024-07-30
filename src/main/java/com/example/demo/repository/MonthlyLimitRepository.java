package com.example.demo.repository;

import com.example.demo.dto.ExpenseCategory;
import com.example.demo.entity.MonthlyLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonthlyLimitRepository extends JpaRepository<MonthlyLimit, Long> {
    Optional<MonthlyLimit> findByAccountNumberAndExpenseCategory(String accountNumber, ExpenseCategory expenseCategory);

    List<MonthlyLimit> findAllByAccountNumber(String accountNumber);
}
