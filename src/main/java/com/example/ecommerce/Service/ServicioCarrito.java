package com.example.ecommerce.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Service.ServiceImp.ServicioCarritoImp;

@Service
public class ServicioCarrito implements ServicioCarritoImp {
  
  
    @Autowired
    RepositorioCarrito repositorioCarrito;

    @Override
    public Carrito guardar(CarritoRequestDto carritoRequestDto) {
      Carrito carrito = new Carrito();
      

      return carrito;
    }

    @Override
    public Optional<Carrito> eliminar(Long idCarrito, Long idProducto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public Carrito agregar(Long idCarrito, Long idProducto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

  
    

  
 
   

 

    

  
      
  

}
