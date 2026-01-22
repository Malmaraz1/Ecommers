package com.example.ecommerce.exceptions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistByEmailValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByCorreo {

    String message() default "El correo ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
