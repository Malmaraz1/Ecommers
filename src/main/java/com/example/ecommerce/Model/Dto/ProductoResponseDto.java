package com.example.ecommerce.Model.Dto;

import com.example.ecommerce.Model.Categoria;



public class ProductoResponseDto {
   private String nombre;
   private Float precio;
   private Categoria categoria;
   private String modelo;
   private String descripcion;
   private String img;
   public ProductoResponseDto(String nombre, Float precio, Categoria categoria, String modelo, String descripcion, String img) {
      this.nombre = nombre;
      this.precio = precio;
      this.categoria = categoria;
      this.modelo = modelo;
      this.descripcion = descripcion;
      this.img = img;
   }
}
