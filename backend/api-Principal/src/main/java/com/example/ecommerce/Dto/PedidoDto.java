package com.example.ecommerce.Dto;

import java.util.ArrayList;
import java.util.List;

import com.example.ecommerce.Dto.Request.ItemCarritoDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {
    private Long id;
    private Long usuario_id;
    private List<ItemCarritoDto> itemCarritoDto = new ArrayList<>();

}
