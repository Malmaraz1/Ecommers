package com.example.ecommerce.Dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {
    private Long id;
    private Long usuario_id;
    private List<ItemPedidoDto> itemPedidoDto = new ArrayList<>();
    @Override
    public String toString() {
        return "PedidoDto [id=" + id + ", usuario_id=" + usuario_id + ", itemPedidoDto=" + itemPedidoDto + "]";
    }

}
