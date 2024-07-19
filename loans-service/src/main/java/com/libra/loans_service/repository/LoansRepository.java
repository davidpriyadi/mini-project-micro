package com.libra.loans_service.repository;

import com.libra.loans_service.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoansRepository extends JpaRepository<Loans, Long> {

    @Query(value = "SELECT * FROM Loans l WHERE l.status = 'ACTIVE' AND l.due_date < CURRENT_DATE", nativeQuery = true)
    List<Loans> findActiveLoansWithOverdueReturnDate();

    @Query(value = "SELECT l.* FROM Loans l JOIN Fines f ON l.id = f.loan_id WHERE l.status = 'ACTIVE' AND f.status = 'UNPAID'", nativeQuery = true)
    List<Loans> findLoansWithUnpaidFines();
}