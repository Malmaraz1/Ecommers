package com.example.mvsc.servicio_control_stock.Dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PedidoMensajeDTO {
    private Long pedidoId;
    private List<ItemPedidoDto> itemPedidoDto;
    private Long usuario_id;
    
}
