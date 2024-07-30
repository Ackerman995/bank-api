package com.example.demo.mapper;

import com.example.demo.dto.MonthlyLimitDto;
import com.example.demo.entity.MonthlyLimit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MonthlyLimitMapper {
    MonthlyLimitDto toDto(MonthlyLimit monthlyLimit);

    MonthlyLimit toEntity(MonthlyLimitDto monthlyLimitDto);

    List<MonthlyLimitDto> toDtos(List<MonthlyLimit> monthlyLimits);
}
