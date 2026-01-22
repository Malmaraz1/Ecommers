package com.example.ecommerce.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.Service.ServiceImp.ServicioUsuario;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistByEmailValidation implements ConstraintValidator<ExistsByCorreo, String> {
  @Autowired
  private ServicioUsuario servicioUsuario;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (servicioUsuario == null) {
      return true;
    }

    return !servicioUsuario.existByEmail(value);
  }

}
