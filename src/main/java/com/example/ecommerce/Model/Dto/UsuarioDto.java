package com.example.ecommerce.Model.Dto;

import lombok.Getter;

@Getter

public class UsuarioDto {

    String nombre;
    String correo;
    public UsuarioDto(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
    
}
