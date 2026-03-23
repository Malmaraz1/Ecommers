package com.example.ecommerce.Service.ServiceImp;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.Dto.CarritoDto;
import com.example.ecommerce.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Pedido;

public interface ServicioCarrito {

    CarritoDto crear(CarritoRequestDto carrito);

    CarritoDto quitarProducto(Long idCarrito, Long idProducto, Integer cantidad);

    CarritoDto agregar(Long idCarrito, Long idProducto, Integer cantidad);

    void deleteById(Long carritoId);

    Optional<Carrito> findById(Long carritoId);

 

}
