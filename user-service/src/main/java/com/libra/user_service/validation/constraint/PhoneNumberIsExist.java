package com.libra.user_service.validation.constraint;

import com.libra.user_service.validation.PhoneNumberExistValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberExistValidator.class)
public @interface PhoneNumberIsExist {
    String message() default "Phone number already exists";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
