package com.example.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Dto.FacturaDto;
import com.example.ecommerce.Dto.ItemFacturaDto;
import com.example.ecommerce.Dto.ItemPedidoDto;
import com.example.ecommerce.Dto.PedidoDto;
import com.example.ecommerce.Model.Factura;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Repository.RepositorioFactura;
import com.example.ecommerce.exceptions.NotFoundException;
@Service
public class ServicioFactura {

    @Autowired
    RepositorioFactura repositorioFactura;

    @Transactional
    public void guardarFactura(Pedido pedido) {

        Factura factura = new Factura();
        factura.crearFactura(pedido);
        repositorioFactura.save(factura);
    }

    @Transactional(readOnly = true)
    public FacturaDto facturaActual(Long pedidoId) {

        Factura factura = repositorioFactura.findByPedidoId(pedidoId);
         if(factura == null){
            new NotFoundException("n o se encontro factura para este pedido con id "+ pedidoId);
         }
          
         

        List<ItemFacturaDto> itemDto = factura.getItemFactura().stream().map(item -> {
            ItemFacturaDto dto = new ItemFacturaDto();
            dto.setId(item.getId());
            dto.setProductoId(item.getProducto().getId());
            dto.setCantidad(item.getCantidad());
            dto.setPrecioUnitario(item.getPrecio());
            dto.setPedido_id(item.getProducto().getId());
            
            return dto;
        }).toList();

        FacturaDto facturaDto = new FacturaDto();
        facturaDto.setComprador(factura.getComprador());
        facturaDto.setFechaEmision(factura.getFechaEmision());
        facturaDto.setItemsFactura(itemDto);
        facturaDto.setId(factura.getId());
        facturaDto.setNumeroFactura(factura.getNumeroFactura());
        facturaDto.setPedido(factura.getPedido());
        facturaDto.setTotal_factura(factura.getTotal_factura());
        return facturaDto;

    }

}
