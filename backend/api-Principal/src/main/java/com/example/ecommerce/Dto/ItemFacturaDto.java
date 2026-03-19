package com.example.ecommerce.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFacturaDto {
     private Long id;
    private int cantidad;
    private int precioUnitario;
    private Long productoId;
    private Long pedido_id;

}
