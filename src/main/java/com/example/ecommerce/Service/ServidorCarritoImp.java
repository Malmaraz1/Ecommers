package com.example.ecommerce.Service;

import java.util.Optional;


import com.example.ecommerce.Model.Dto.CarritoResponseDto;
import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;


public interface ServidorCarritoImp {

    CarritoResponseDto guardar(CarritoRequestDto carrito);
     
    Optional <CarritoResponseDto> eliminar(Long idProducto);
     CarritoResponseDto agregar(Long idProducto);
    
    
}
