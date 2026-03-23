package com.example.ecommerce.Service;

import com.example.ecommerce.Repository.RepositorioPedido;
import com.example.ecommerce.Repository.RepositorioUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Dto.ItemPedidoDto;
import com.example.ecommerce.Dto.PedidoDto;
import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.EstadoPedido;
import com.example.ecommerce.Model.ItemPedido;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Service.ServiceImp.ServicioCarrito;
import com.example.ecommerce.Service.ServiceImp.ServicioPedido;
import com.example.ecommerce.exceptions.NotFoundException;

@Service
public class ServicioPedidoImp implements ServicioPedido {
    @Autowired
    RepositorioPedido repositorioPedido;
    @Autowired
    ServicioCarrito servicioCarrito;
    @Autowired
    RepositorioUsuario repositorioUsuario;

    ServicioPedidoImp(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    @Override
    @Transactional
    public PedidoDto generarPedido(Long carritoId) {

        Carrito carrito = servicioCarrito.findById(carritoId).orElseThrow(
                () -> new NotFoundException("No se encontro el carrito con id  " + carritoId));
                
        Usuario usuario = repositorioUsuario.getReferenceById(carrito.getComprador().getId());

        Pedido pedido = new Pedido();
        List<ItemPedido> itemDtos = carrito.getItemsCarrito().stream().map(item -> {
            ItemPedido dto = new ItemPedido();
            dto.setProducto(item.getProducto());
            dto.setCantidad(item.getCantidad());
            dto.setPrecioUnitario(item.getPrecioUnitario());
            dto.setPedido(pedido);

            return dto;
        }).toList();

        pedido.setComprador(usuario);
        pedido.setItems_pedido(itemDtos);
        pedido.setEstadoPedido(EstadoPedido.PENDIENTE);

        Pedido pedido2 = repositorioPedido.save(pedido);

        servicioCarrito.deleteById(carritoId);

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

    @Transactional(readOnly = true)
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
