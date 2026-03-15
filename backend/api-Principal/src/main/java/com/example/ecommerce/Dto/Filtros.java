package com.example.ecommerce.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class Filtros {
    String categoria;
    Integer precioMax;
    Integer precioMin;
}
