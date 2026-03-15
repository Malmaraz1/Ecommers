package com.example.ecommerce.Dto.Request;

import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.exceptions.ExistByProductoName;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo que representa un producto en el sistema")
public class ProductoRequestDto {
   @NotBlank(message = "El nombre no puede estar vacío")
   @Schema(example = "Lavarropas Drean Next 8.14", description = "Nombre del producto")
   @ExistByProductoName
   private String nombre;

   @NotNull(message = "El precio es obligatorio")
   @Positive(message = "El precio debe ser positivo")
   @Schema(example = "150000.00", description = "Precio unitario en pesos")
   private int precio;

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

   public ProductoRequestDto mapearProducto(Producto producto) {

      this.setNombre(producto.getNombre());
      this.setPrecio(producto.getPrecio());

      // Sacamos el ID de la categoría, verificando que no sea nula para evitar un
      // NullPointerException
      if (producto.getCategoria() != null) {
         this.setCategoria_id(producto.getCategoria().getId());
      }

      this.setModelo(producto.getModelo());

      // Ojo acá: mapeamos al nombre exacto que le pusiste en la entidad
      this.setDescripcion(producto.getDescripcion_productro());

      this.setImg(producto.getImagen());
      this.setMarca(producto.getMarca());
      
        return this;
   }
  


}
