package com.example.ecommerce.Model.Dto.Request;

import com.example.ecommerce.Model.Categoria;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestDto {
   @NotBlank(message = "El nombre no puede estar vacío")
   private String nombre;

   @NotNull(message = "El precio es obligatorio") // Double requiere @NotNull
   @Positive(message = "El precio debe ser positivo")
   private Double precio;

   @NotNull(message = "La categoría es obligatoria") // Para Objetos o Enums se usa @NotNull
   private Categoria categoria;

   @NotBlank(message = "El modelo no puede estar vacío")
   private String modelo;

   @Size(max = 500, message = "La descripción es demasiado larga")
   private String descripcion;

   private String img;

   public ProductoRequestDto(String nombre, Double precio, Categoria categoria, String modelo, String descripcion,
         String img) {
      this.nombre = nombre;
      this.precio = precio;
      this.categoria = categoria;
      this.modelo = modelo;
      this.descripcion = descripcion;
      this.img = img;
   }
}
