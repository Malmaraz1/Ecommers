package com.example.mvsc.servicio_control_stock.Dto.RequestDto;

import java.time.LocalDate;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestStock {

 
    @NotNull(message = "El ID no puede ser nulo")
    @Min(value = 1, message = "El ID debe ser un número positivo")
    private Long deposito_id;
    @NotNull(message = "El ID no puede ser nulo")
    @Min(value = 1, message = "El ID debe ser un número positivo")
    private Long producto_id;
    @Positive(message = "El precio debe ser positivo")
    private Integer cantidad;
    @Positive(message = "El precio debe ser positivo")
    private Integer punto_reposicion;
    @Positive(message = "El precio debe ser positivo")
    private Integer stock_maximo;
    @Size(max = 500, message = "La descripción es demasiado larga")
    private String detalle;
    @FutureOrPresent(message = "la fecha debe ser actual o una futura")
    private LocalDate proxima_reposicion;



}
