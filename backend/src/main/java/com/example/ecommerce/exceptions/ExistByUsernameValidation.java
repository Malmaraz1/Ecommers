package com.example.ecommerce.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ecommerce.Service.ServiceImp.ServicioUsuario;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByUsernameValidation implements ConstraintValidator<ExistByUserName, String> {
    @Autowired
    private ServicioUsuario servicioUsuario;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (servicioUsuario == null) {
            return true;
        }

        return !servicioUsuario.existByUsername(value);

    }

}
