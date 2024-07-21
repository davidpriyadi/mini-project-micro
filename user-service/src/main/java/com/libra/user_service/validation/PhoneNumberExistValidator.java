package com.libra.user_service.validation;

import com.libra.user_service.repository.UserRepository;
import com.libra.user_service.validation.constraint.PhoneNumberIsExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhoneNumberExistValidator implements ConstraintValidator<PhoneNumberIsExist, String> {

    private final UserRepository userRepository;


    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsUsersByPhoneNumber(string);
    }
}
