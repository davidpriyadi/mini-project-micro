package com.libra.loans_service.dto;

import com.libra.loans_service.validation.constraint.BookIdValid;
import com.libra.loans_service.validation.constraint.NoOutstandingFines;
import com.libra.loans_service.validation.constraint.UserIdValid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoansRequest {

    @BookIdValid
    private Long bookId;
    @UserIdValid
    @NoOutstandingFines
    private Long userId;
    @NotNull
    private LocalDate loanDate;
    @NotNull
    private LocalDate dueDate;
    private String status;

}
