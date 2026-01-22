package com.example.ecommerce.Dto.Request;

import lombok.Getter;

@Getter
public class ItemCarritoRequestDto {
    private Integer cantidad;
    private Double precioUnitario;
    private Long carrito_id;
    private Long producto_id;
}
