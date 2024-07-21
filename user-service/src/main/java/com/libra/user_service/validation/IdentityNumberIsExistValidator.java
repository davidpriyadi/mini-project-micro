package com.libra.user_service.validation;

import com.libra.user_service.repository.UserRepository;
import com.libra.user_service.validation.constraint.IdentityNumberIsExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IdentityNumberIsExistValidator implements ConstraintValidator<IdentityNumberIsExist, String> {

    private final UserRepository userRepository;


    @Override
    public boolean isValid(String identityNumber, ConstraintValidatorContext context) {
        return !userRepository.existsUsersByIdentityNumber(identityNumber);
    }
}
