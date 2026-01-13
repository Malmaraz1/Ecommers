 package com.example.ecommerce.Model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@DiscriminatorValue("comprador")

@Entity
@NoArgsConstructor 
@Getter @Setter
public class Comprador extends Usuario {

    public Comprador(String nombre, String correo) {
        super(nombre, correo);
    }
   
    
}