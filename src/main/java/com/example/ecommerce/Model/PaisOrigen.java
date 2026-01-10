package com.example.ecommerce.Model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class PaisOrigen {
    private String pais;
}
