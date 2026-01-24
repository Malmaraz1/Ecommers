package com.example.ecommerce.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class Filtros {
    String categoria;
    Double precioMax;
    Double precioMin;
}
