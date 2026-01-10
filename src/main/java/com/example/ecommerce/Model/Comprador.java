 package com.example.ecommerce.Model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("comprador")
@Entity
public class Comprador extends Usuario {

    public Comprador(String nombre, String correo) {
        super(nombre, correo);
    }
   
    
}