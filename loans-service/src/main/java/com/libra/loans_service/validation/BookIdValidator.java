package com.libra.loans_service.validation;

import com.libra.loans_service.client.BookClient;
import com.libra.loans_service.validation.constraint.BookIdValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClientException;

@RequiredArgsConstructor
public class BookIdValidator implements ConstraintValidator<BookIdValid, Long> {

    private final BookClient bookClient;

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext context) {
        try{
            bookClient.getBookById(aLong);
            return true;
        }catch (RestClientException e) {
            return false;
        }
    }
}
