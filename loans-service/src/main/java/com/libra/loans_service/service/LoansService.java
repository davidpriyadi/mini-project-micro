package com.libra.loans_service.service;

import com.libra.loans_service.dto.LoansDto;
import com.libra.loans_service.dto.LoansRequest;
import com.libra.loans_service.dto.mapper.LoanMapper;
import com.libra.loans_service.dto.mapper.LoansRequestMapper;
import com.libra.loans_service.entity.Fines;
import com.libra.loans_service.entity.Loans;
import com.libra.loans_service.repository.FineRepository;
import com.libra.loans_service.repository.LoansRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Slf4j
@Service
@RequiredArgsConstructor
public class LoansService {

    private final LoansRepository loansRepository;
    private final FineRepository finesRepository;
    private final LoansRequestMapper loansRequestMapper;
    private final LoanMapper loanMapper;

    //cek
    public LoansDto createLoan(LoansRequest loansDto) {
        var loan = loansRequestMapper.loanDTOToLoan(loansDto);
        return loanMapper.loanToLoanDTO(loansRepository.save(loan));
    }

    public LoansDto getLoanById(Long id) {
        var loan = loansRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Loan with id " + id + " not found"));
        return loanMapper.loanToLoanDTO(loan);
    }

    public LoansDto returnBook(Long loanId) {
        var loan = loansRepository.findById(loanId)
                .orElseThrow(() -> new EntityNotFoundException("Loan with id " + loanId + " not found"));

        if (loan.getDueDate().isBefore(LocalDate.now())) {
            Fines fine = Fines.builder()
                    .userId(loan.getUserId())
                    .loan(loan)
                    .amount(calculateFine(loan.getDueDate(), LocalDate.now()))
                    .status(Fines.FineStatus.UNPAID)
                    .issuedDate(LocalDate.now())
                    .build();
            finesRepository.save(fine);
        }

        loan.setStatus(Loans.LoanStatus.RETURNED);

        return loanMapper.loanToLoanDTO(loansRepository.save(loan));
    }


    private double calculateFine(LocalDate dueDate, LocalDate returnDate) {
        long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
        return daysLate * 1000;
    }
}
