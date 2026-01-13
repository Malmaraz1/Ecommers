package com.example.ecommerce.Model.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequestDto {
    @NotNull(message = "El nivel no puede ser nulo")
    @PositiveOrZero(message = "El nivel debe ser un número positivo")
    private Integer nivel;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;
    Long id;
    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String descripcion;

    @NotBlank(message = "El slug es obligatorio")
    @Size(max = 100, message = "El slug no puede exceder los 100 caracteres")
    private String slug;

    private Long categoria_padre_id;

    public CategoriaRequestDto(
            @NotNull(message = "El nivel no puede ser nulo") @PositiveOrZero(message = "El nivel debe ser un número positivo") Integer nivel,
            @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres") String nombre,
            Long id,
            @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres") String descripcion,
            @NotBlank(message = "El slug es obligatorio") @Size(max = 100, message = "El slug no puede exceder los 100 caracteres") String slug,
            Long categoria_padre_id) {
        this.nivel = nivel;
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.slug = slug;
        this.categoria_padre_id = categoria_padre_id;
    }

}
