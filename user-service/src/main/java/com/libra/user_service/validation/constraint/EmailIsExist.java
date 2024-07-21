package com.libra.user_service.validation.constraint;

import com.libra.user_service.validation.EmailExistValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailExistValidator.class)
public @interface EmailIsExist {

    /**
     *
     * @return String
     */
    String message() default "Email already exists";

    /**
     *
     * @return class
     */
    Class<?>[] groups() default {};

    /**
     *
     * @return class
     */
    Class<?>[] payload() default {};
}
