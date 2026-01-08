package com.example.ecommerce.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Usuario {
    private String nombre;
    private String correo;
    private Float saldo;
    private String contrasenia;
    

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    
    }
    
    public void ingresarSaldo(Float saldo){
      if(saldo < 0){
        throw new RuntimeException("No se puede agregar Saldo negativo");
      }
        this.saldo += saldo;
    }

}