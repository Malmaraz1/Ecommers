package com.example.ecommerce.Service;

import com.example.ecommerce.Repository.RepositorioPedido;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Dto.ItemPedidoDto;
import com.example.ecommerce.Dto.PedidoDto;
import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.EstadoPedido;
import com.example.ecommerce.Model.ItemPedido;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Service.ServiceImp.ServicioPedido;
import com.example.ecommerce.exceptions.NotFoundException;

@Service
public class ServicioPedidoImp implements ServicioPedido {
    @Autowired
    RepositorioPedido repositorioPedido;
    @Autowired
    RepositorioCarrito repositorioCarrito;

    ServicioPedidoImp(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    @Override
    public PedidoDto generarPedido(Long carritoId) {

        Carrito carrito = repositorioCarrito.findById(carritoId).orElseThrow(
                () -> new NotFoundException("No se encontro el carrito con id  " + carritoId));

        Pedido pedido = new Pedido();
        List<ItemPedido> itemDtos = carrito.getItemsCarrito().stream().map(item -> {
            ItemPedido dto = new ItemPedido();
            dto.setProducto(item.getProducto());
            dto.setCantidad(item.getCantidad());
            dto.setPrecioUnitario(item.getPrecioUnitario());
            dto.setPedido(pedido);

            return dto;
        }).toList();

        pedido.setComprador(carrito.getComprador());
        pedido.setItems_pedido(itemDtos);
        pedido.setEstadoPedido(EstadoPedido.PENDIENTE);

        Pedido pedido2 = repositorioPedido.save(pedido);

        repositorioCarrito.deleteById(carritoId);
        PedidoDto pedidoDto = new PedidoDto();

        List<ItemPedidoDto> itemDto = pedido2.getItems_pedido().stream().map(item -> {
            ItemPedidoDto dto = new ItemPedidoDto();
            dto.setId(item.getId());
            dto.setProductoId(item.getProducto().getId());
            dto.setCantidad(item.getCantidad());
            dto.setPrecioUnitario(item.getPrecioUnitario());
            dto.setPedido_id(item.getPedido().getId());

            return dto;
        }).toList();

        pedidoDto.setItemPedidoDto(itemDto);
        pedidoDto.setId(pedido2.getId());
        pedidoDto.setUsuario_id(pedido2.getComprador().getId());

        return pedidoDto;

    }

    public PedidoDto getPedido(Long pedido_id) {

        Pedido pedido = repositorioPedido.findById(pedido_id).orElseThrow(
                () -> new NotFoundException("No se encontro el pedido con id " + pedido_id));

        PedidoDto pedidoDto = new PedidoDto();

        List<ItemPedidoDto> itemDto = pedido.getItems_pedido().stream().map(item -> {
            ItemPedidoDto dto = new ItemPedidoDto();
            dto.setId(item.getId());
            dto.setProductoId(item.getProducto().getId());
            dto.setCantidad(item.getCantidad());
            dto.setPrecioUnitario(item.getPrecioUnitario());
            return dto;
        }).toList();

        pedidoDto.setId(pedido_id);
        pedidoDto.setItemPedidoDto(itemDto);
        pedidoDto.setUsuario_id(pedido.getComprador().getId());
        return pedidoDto;

    }

}
