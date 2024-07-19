package com.libra.loans_service.dto.mapper;

import com.libra.loans_service.dto.LoansDto;
import com.libra.loans_service.entity.Loans;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoansDto loanToLoanDTO(Loans loan);
    Loans loanDTOToLoan(LoansDto loanDTO);
}