package com.example.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoriaDto {
  private String nombre;
  private String descripcion;
  private String slug;
}
