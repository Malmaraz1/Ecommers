package com.example.ecommerce.Service;

import java.util.Optional;

import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Dto.Response.CarritoResponseDto;
import com.example.ecommerce.Service.ServiceImp.ServicioCarritoImp;


public class ServicioCarrito implements ServicioCarritoImp {

    @Override
    public CarritoResponseDto guardar(CarritoRequestDto carrito) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public Optional<CarritoResponseDto> eliminar(Long idCarrito, Long idProducto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public CarritoResponseDto agregar(Long idCarrito, Long idProducto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

 

    

  
      
  

}
