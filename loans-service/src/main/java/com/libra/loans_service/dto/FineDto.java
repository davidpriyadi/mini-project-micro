package com.libra.loans_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.libra.loans_service.entity.Fines;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FineDto {

    private Long id;

    private Long userId;

    private Double amount;

    private String reason;

    @Enumerated(EnumType.STRING)
    private Fines.FineStatus status;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate issuedDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate paidDate;

    private LoansDto loan;
}
