package com.libra.loans_service.validation.constraint;

import com.libra.loans_service.validation.NoOutstandingFinesValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NoOutstandingFinesValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoOutstandingFines {
    String message() default "User has outstanding fines";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}