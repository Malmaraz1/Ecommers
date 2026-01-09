package com.example.ecommerce.Service.ServiceImp;

import java.util.Optional;

import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Dto.Response.CarritoResponseDto;


public interface ServicioCarritoImp {

    CarritoResponseDto guardar(CarritoRequestDto carrito); 
    Optional <CarritoResponseDto> eliminar(Long idCarrito , Long idProducto);
    CarritoResponseDto agregar(Long idCarrito  , Long idProducto);
    
    
}
