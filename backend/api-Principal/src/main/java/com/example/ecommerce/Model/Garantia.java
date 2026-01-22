package com.example.ecommerce.Model;

import jakarta.persistence.Embeddable;



@Embeddable
public class Garantia {
    private Integer meses;
    public String descripcion;
    
    public void garantia() {
        if (meses < 0) throw new IllegalArgumentException("La garantía no puede ser negativa");
    }

   
}
