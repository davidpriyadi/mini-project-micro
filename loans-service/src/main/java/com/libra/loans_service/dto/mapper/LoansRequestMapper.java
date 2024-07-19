package com.libra.loans_service.dto.mapper;

import com.libra.loans_service.dto.LoansRequest;
import com.libra.loans_service.entity.Loans;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoansRequestMapper {
    Loans loanDTOToLoan(LoansRequest loanDTO);
}