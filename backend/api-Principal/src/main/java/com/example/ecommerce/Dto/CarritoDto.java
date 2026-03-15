package com.example.ecommerce.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarritoDto {

    private Long id;

    private Long comprador_id;

    private List<ItemCarritoDto> itemsCarrito = new ArrayList<>();

    private LocalDate ultimaActualizacion = LocalDate.now();

}
