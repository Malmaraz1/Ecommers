package com.example.ecommerce.Service.ServiceImp;

import java.util.Optional;

import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Carrito;



public interface ServicioCarritoImp {

    Carrito guardar(CarritoRequestDto carrito); 
    Optional <Carrito> eliminar(Long idCarrito , Long idProducto);
    Carrito agregar(Long idCarrito  , Long idProducto);
    
    
}
