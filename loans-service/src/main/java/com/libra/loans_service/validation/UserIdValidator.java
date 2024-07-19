package com.libra.loans_service.validation;

import com.libra.loans_service.client.BookClient;
import com.libra.loans_service.client.UserClient;
import com.libra.loans_service.validation.constraint.BookIdValid;
import com.libra.loans_service.validation.constraint.UserIdValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClientException;

@RequiredArgsConstructor
public class UserIdValidator implements ConstraintValidator<UserIdValid, Long> {

    private final UserClient userClient;

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext context) {
        try{
            userClient.getUserById(aLong);
            return true;
        }catch (RestClientException e) {
            return false;
        }
    }
}
