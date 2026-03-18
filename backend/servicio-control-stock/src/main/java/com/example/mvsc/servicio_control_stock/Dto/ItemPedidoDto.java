package com.example.mvsc.servicio_control_stock.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoDto {
     private Long id;
    private int cantidad;
    private int precioUnitario;
    private Long productoId;

}
