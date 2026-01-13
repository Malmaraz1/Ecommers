package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Pedido;



public interface ServicioPedidoImp {

 Pedido generarPedido(CarritoRequestDto carritoRequestDto);


    
}
