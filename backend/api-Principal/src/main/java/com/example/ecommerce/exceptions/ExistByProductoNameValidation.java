package com.example.ecommerce.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.Service.ServiceImp.ServicioProducto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistByProductoNameValidation implements ConstraintValidator<ExistByProductoName, String> {
    
    @Autowired
    ServicioProducto servicioProducto;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (servicioProducto == null) {
            return true;
        }

        return !servicioProducto.existByProductoName(value);
    }

}
