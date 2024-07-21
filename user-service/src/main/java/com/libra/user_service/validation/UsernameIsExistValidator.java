package com.libra.user_service.validation;

import com.libra.user_service.repository.UserRepository;
import com.libra.user_service.validation.constraint.UsernameIsExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsernameIsExistValidator implements ConstraintValidator<UsernameIsExist, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userRepository.existsUsersByUsername(username);
    }
}
