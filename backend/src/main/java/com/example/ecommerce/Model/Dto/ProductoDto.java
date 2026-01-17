package com.example.ecommerce.Model.Dto;

import com.example.ecommerce.Model.Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductoDto {
private String nombre;
private String modelo;
private Double precio;
private String descripcion;
private String categoria;

public ProductoDto(Producto p) {
    this.nombre = p.getNombre();
    this.modelo = p.getModelo();
    this.precio = p.getPrecio();
    this.descripcion = p.getDescripcion_productro();
    this.categoria = p.getCategoria().getNombre();
  
}

}
    
