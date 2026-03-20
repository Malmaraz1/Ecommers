package com.example.mvsc.servicio_control_stock.Dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PedidoMensajeDTO {
     private Long id;
    private Long usuario_id;
    private List<ItemPedidoDto> itemPedidoDto = new ArrayList<>();
   
    
}
