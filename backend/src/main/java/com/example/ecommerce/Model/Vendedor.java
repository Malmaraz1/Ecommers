package com.example.ecommerce.Model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("vendedor")
@Entity
public class Vendedor extends Usuario {

    public Vendedor(String nombre, String correo) {
        super(nombre, correo);
        
    }

    
}