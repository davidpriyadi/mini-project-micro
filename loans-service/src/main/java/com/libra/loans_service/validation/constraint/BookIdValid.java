package com.libra.loans_service.validation.constraint;


import com.libra.loans_service.validation.BookIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = BookIdValidator.class)
public @interface BookIdValid {

    /**
     *
     * @return String
     */
    String message() default "Book id is not valid";

    /**
     *
     * @return class
     */
    Class<?>[] groups() default {};

    /**
     *
     * @return class
     */
    Class<? extends Payload>[] payload() default {};
}
