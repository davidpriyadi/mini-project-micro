package com.libra.loans_service.config.schedule;

import com.libra.loans_service.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoansScheduler {

    private final LoansRepository loansRepository;

    @Scheduled(cron = "0 * * * * ?")
    public void checkOverdueLoans() {
        var overdueLoans = loansRepository.findActiveLoansWithOverdueReturnDate();
        overdueLoans.forEach(loan -> log.info("Overdue loan found send notification: {}", loan));
    }

    @Scheduled(cron = "0 * * * * ?")
    public void notifyUnpaidFines() {
        var loansWithUnpaidFines = loansRepository.findLoansWithUnpaidFines();
        loansWithUnpaidFines.forEach(loan -> log.info("Loan with unpaid fine found, send notification: {}", loan));
    }
}