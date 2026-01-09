package com.example.ecommerce.Service.ServiceImp;

import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Dto.Response.ProductoResponseDto;

public interface ServicioPedidoImp {

 ProductoResponseDto generarPedido(CarritoRequestDto carritoRequestDto);


    
}
