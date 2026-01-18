package com.example.ecommerce.Dto.Request;

import com.example.ecommerce.exceptions.ExistByUserName;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UsuarioRequestDto {
    @ExistByUserName
    @NotBlank(message = "El nombre no puedo estar vacio")
    private String nombre;
    @Email(message = "Formato de email inválido")
    private String email;
    @NotBlank(message = "La contraseña no puedo estar vacio")
    private String contraseña;
    private boolean isAdmin = false;
    

}
