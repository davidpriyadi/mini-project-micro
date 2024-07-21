package com.libra.user_service.validation;

import com.libra.user_service.repository.UserRepository;
import com.libra.user_service.validation.constraint.EmailIsExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailExistValidator implements ConstraintValidator<EmailIsExist, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !userRepository.existsUsersByEmail(email);
    }
}
