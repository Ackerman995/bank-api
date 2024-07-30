package com.example.demo.service;

import com.example.demo.entity.Transaction;
import com.example.demo.dto.TransactionDto;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final MonthlyLimitService monthlyLimitService;
    private final TransactionMapper transactionMapper;

    @Override
    @Transactional
    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        log.info("Transaction is going to save");
        Transaction transaction = transactionMapper.toEntity(transactionDto);
        if (monthlyLimitService.isMonthlyLimitExceeded(transaction)) {
            transaction.setLimitExceeded(true);
        }

        transactionRepository.save(transaction);
        log.info("Transaction is saved to DB: " + transaction);
        return transactionMapper.toDto(transaction);
    }

    @Override
    @Transactional
    public List<TransactionDto> getLimitExceededTransactions(String accountNumber) {
        return transactionRepository.findLimitExceededTransactions(accountNumber).stream()
                .map(transactionMapper::toDto).toList();
    }
}