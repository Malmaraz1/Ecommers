package com.example.mvsc.servicio_control_stock.Dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PedidoMensajeDTO {
    private Long pedidoId;
    private List<ItemStockDTO> items;
    private Long usuario_id;
    
}
