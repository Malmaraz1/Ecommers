package com.example.ecommerce.Service.ServiceImp;



import com.example.ecommerce.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Carrito;



public interface ServicioCarrito {

    Carrito crear(CarritoRequestDto carrito); 
    Carrito eliminar(Long idCarrito , Long idProducto  ,Integer cantidad);
    Carrito agregar(Long idCarrito  , Long idProducto ,Integer cantidad);
    
    
}
