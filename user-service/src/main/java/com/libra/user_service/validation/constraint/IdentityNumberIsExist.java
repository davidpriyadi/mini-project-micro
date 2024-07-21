package com.libra.user_service.validation.constraint;

import com.libra.user_service.validation.IdentityNumberIsExistValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IdentityNumberIsExistValidator.class)
public @interface IdentityNumberIsExist {
    String message() default "Identity number already exists";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
