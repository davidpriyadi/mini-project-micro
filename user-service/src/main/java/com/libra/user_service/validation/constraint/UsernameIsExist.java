package com.libra.user_service.validation.constraint;

import com.libra.user_service.validation.UsernameIsExistValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameIsExistValidator.class)
public @interface UsernameIsExist {
    String message() default "Username already exists";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
