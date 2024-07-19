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
@ToString
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;

    private Long userId;

    private LocalDate loanDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @OneToOne(mappedBy = "loan")
    private Fines fines;

    public enum LoanStatus {
        ACTIVE,
        RETURNED,
        OVERDUE
    }
}
