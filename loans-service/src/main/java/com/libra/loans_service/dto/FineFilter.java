package com.libra.loans_service.dto;

import com.libra.loans_service.entity.Fines;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FineFilter {
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Fines.FineStatus status;

    private LocalDate issuedDate;

    private LocalDate paidDate;

    private Long bookId;
}
