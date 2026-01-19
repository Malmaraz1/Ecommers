package com.example.ecommerce.Dto.Request;

import com.example.ecommerce.exceptions.ExistByUserName;
import com.example.ecommerce.exceptions.ExistsByCorreo;

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
    @ExistsByCorreo
    @NotBlank(message = "el correo no puede estar vacio") 
    @Email(message = "formato de correo invalido")
    
    private String correo;
    @NotBlank(message = "La contraseña no puedo estar vacio")
    private String contraseña;
    private boolean isAdmin = false;
    

}
