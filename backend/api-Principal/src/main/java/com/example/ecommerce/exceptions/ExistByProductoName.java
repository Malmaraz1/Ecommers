package com.example.ecommerce.exceptions;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistByProductoNameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistByProductoName {

     String message() default "El nombre del producto ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    
}
