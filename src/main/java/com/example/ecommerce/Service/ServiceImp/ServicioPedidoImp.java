package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Dto.Response.PedidoResponse;


public interface ServicioPedidoImp {

 PedidoResponse generarPedido(CarritoRequestDto carritoRequestDto);


    
}
