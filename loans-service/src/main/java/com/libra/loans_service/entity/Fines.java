package com.libra.loans_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Double amount;

    private String reason;

    @Enumerated(EnumType.STRING)
    private FineStatus status;

    private LocalDate issuedDate;

    private LocalDate paidDate;

    @OneToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "id")
    private Loans loan;

    public enum FineStatus {
        PAID,
        UNPAID
    }
}
