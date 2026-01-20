package com.example.ecommerce.Dto.Request;

import com.example.ecommerce.Model.PaisOrigen;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestDto {
   @NotBlank(message = "El nombre no puede estar vacío")
   private String nombre;

   @NotNull(message = "El precio es obligatorio")
   @Positive(message = "El precio debe ser positivo")
   private Double precio;

   @NotNull(message = "El ID no puede ser nulo")
   @Min(value = 1, message = "El ID debe ser un número positivo")
   private Long categoria_id;

   @NotBlank(message = "El modelo no puede estar vacío")
   private String modelo;

   @Size(max = 500, message = "La descripción es demasiado larga")
   private String descripcion;
   @Null
   private String img;
   @NotBlank(message = "La marca no puede estar vacia")
   private String marca;
   @NotBlank(message = "El fabricante no puede estar vacia")
   private String fabricante;
   @NotBlank(message = "El pais no puede estar vacío")
   private PaisOrigen paisOrigen;

}
