package com.libra.loans_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoansDto {
    private Long id;
    private Long bookId;
    private Long userId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate loanDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dueDate;
    private String status;
}
