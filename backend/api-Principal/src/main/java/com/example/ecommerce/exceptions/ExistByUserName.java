package com.example.ecommerce.exceptions;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistByUsernameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistByUserName {

    String message() default "El nombre de usuario ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
