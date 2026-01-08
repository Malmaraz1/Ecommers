package com.example.ecommerce.Model.Dto.Request;

import com.example.ecommerce.Model.Categoria;



public class ProductoRequestDto {
   private String nombre;
   private Float precio;
   private Categoria categoria;
   private String modelo;
   private String descripcion;
   private String img;
   public ProductoRequestDto(String nombre, Float precio, Categoria categoria, String modelo, String descripcion, String img) {
      this.nombre = nombre;
      this.precio = precio;
      this.categoria = categoria;
      this.modelo = modelo;
      this.descripcion = descripcion;
      this.img = img;
   }
}
