package com.example.ecommerce.Dto;

import com.example.ecommerce.Model.Producto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductoDto {
private Long id;
private String nombre;
private String modelo;
private Double precio;
private String descripcion;
private String categoria;

public ProductoDto(Producto p) {
    this.id = p.getId();
    this.nombre = p.getNombre();
    this.modelo = p.getModelo();
    this.precio = p.getPrecio();
    this.descripcion = p.getDescripcion_productro();
    this.categoria = p.getCategoria().getNombre();
  
}

}
    
