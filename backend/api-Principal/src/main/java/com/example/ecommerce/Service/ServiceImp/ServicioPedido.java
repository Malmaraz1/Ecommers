package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Pedido;



public interface ServicioPedido {

 Pedido generarPedido(CarritoRequestDto carritoRequestDto);


    
}
