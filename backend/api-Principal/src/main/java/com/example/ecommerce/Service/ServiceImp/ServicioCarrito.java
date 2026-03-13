package com.example.ecommerce.Service.ServiceImp;



import com.example.ecommerce.Dto.CarritoDto;
import com.example.ecommerce.Dto.Request.CarritoRequestDto;




public interface ServicioCarrito {

    CarritoDto crear(CarritoRequestDto carrito); 
    CarritoDto quitarProducto(Long idCarrito , Long idProducto  ,Integer cantidad);
    CarritoDto agregar(Long idCarrito  , Long idProducto ,Integer cantidad);
    
    
}
