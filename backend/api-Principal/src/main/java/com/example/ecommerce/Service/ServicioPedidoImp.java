package com.example.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Dto.ItemCarritoDto;
import com.example.ecommerce.Dto.PedidoDto;
import com.example.ecommerce.Model.Carrito;

import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Service.ServiceImp.ServicioPedido;

@Service
public class ServicioPedidoImp implements ServicioPedido {

    @Autowired
    RepositorioCarrito repositorioCarrito;

    @Override
    public PedidoDto generarPedido(Long carritoId) {

        Carrito carrito = repositorioCarrito.findById(carritoId).orElseThrow();

        PedidoDto pedidoDto = new PedidoDto();

        List<ItemCarritoDto> itemDtos = carrito.getItemsCarrito().stream().map(item -> {
            ItemCarritoDto dto = new ItemCarritoDto();
            dto.setId(item.getId());
            dto.setCantidad(item.getCantidad());
            dto.setPrecioUnitario(item.getPrecioUnitario());
            dto.setProductoId(item.getProducto().getId());
            return dto;
        }).toList();
        pedidoDto.setUsuario_id(carrito.getComprador().getId());
        pedidoDto.setItemCarritoDto(itemDtos);

        return pedidoDto;

    }

}
