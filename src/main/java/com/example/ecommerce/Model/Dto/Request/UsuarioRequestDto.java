package com.example.ecommerce.Model.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDto {
    @NotBlank(message = "El nombre no puedo estar vacio")
    private String nombre;
    @Email(message = "Formato de email inválido")
    private String email;
    
}
