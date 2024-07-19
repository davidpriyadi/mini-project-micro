package com.libra.loans_service.validation;

import com.libra.loans_service.entity.Fines;
import com.libra.loans_service.repository.FineRepository;
import com.libra.loans_service.validation.constraint.NoOutstandingFines;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NoOutstandingFinesValidator implements ConstraintValidator<NoOutstandingFines, Long> {

    private final FineRepository finesRepository;

    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {
        return finesRepository.findByUserIdAndStatus(userId, Fines.FineStatus.UNPAID).isEmpty();
    }
}