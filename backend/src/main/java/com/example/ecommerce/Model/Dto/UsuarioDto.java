package com.example.ecommerce.Model.Dto;

import lombok.Getter;

@Getter

public class UsuarioDto {

    String nombre;
    String correo;
    Long id;
    public UsuarioDto(String nombre, String correo, Long id) {
        this.nombre = nombre;
        this.correo = correo;
        this.id = id;
    }
  
    
}
