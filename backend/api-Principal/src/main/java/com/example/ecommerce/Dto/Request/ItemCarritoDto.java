package com.example.ecommerce.Dto.Request;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemCarritoDto {
    private Long id;
    private int cantidad;
    private int precioUnitario;
    private Long productoId;
}
