package com.example.ecommerce.Dto.Request;


import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Modelo que representa un producto en el sistema")
public class ProductoRequestDto {
   @NotBlank(message = "El nombre no puede estar vacío")
   @Schema(example = "Lavarropas Drean Next 8.14", description = "Nombre del producto")
   private String nombre;

   @NotNull(message = "El precio es obligatorio")
   @Positive(message = "El precio debe ser positivo")
   @Schema(example = "150000.00", description = "Precio unitario en pesos")
   private Double precio;

   @NotNull(message = "El ID no puede ser nulo")
   @Min(value = 1, message = "El ID debe ser un número positivo")
   @Schema(example = "1", description = "categoria del producto")
   private Long categoria_id;

   @NotBlank(message = "El modelo no puede estar vacío")
   @Schema(example = "Next 8.14 WCR", description = "Modelo del producto")
   private String modelo;

   @Size(max = 500, message = "La descripción es demasiado larga")
   @Schema(example = "descripcion de prueba", description = "descripcion del producto")
   private String descripcion;
   @Null
   @Schema(example = "https://tusitio.com/default-placeholder.png", description = "imagen del producto")
   private String img;
   @NotBlank(message = "La marca no puede estar vacia")
   @Schema(example = "Dream", description = "marca del producto")
   private String marca;
   

}
