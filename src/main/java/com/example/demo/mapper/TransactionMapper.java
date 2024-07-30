package com.example.demo.mapper;

import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    Transaction toEntity(TransactionDto transactionDto);

    TransactionDto toDto(Transaction transaction);
}
