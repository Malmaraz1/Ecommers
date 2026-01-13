package com.example.ecommerce.Service;

import java.beans.Transient;
import java.time.LocalDate;



import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Carrito;

import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Repository.RepositorioProducto;
import com.example.ecommerce.Repository.RepositorioUsuario;
import com.example.ecommerce.Service.ServiceImp.ServicioCarritoImp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioCarrrito implements ServicioCarritoImp {

    private final RepositorioCarrito repositorioCarrito;
    private final RepositorioUsuario repositorioUsuario;
    
    private final ServicioAgregarCarrito servicioAgregarCarrito;
    private final ServicioQuitarItemCarrito servicioQuitarItemCarrito;

    @Override
    public Carrito crear(CarritoRequestDto carritoRequestDto) {

        Usuario usuario = repositorioUsuario.findById(carritoRequestDto.getUsuario_id())
                .orElseThrow(() -> new EntityNotFoundException("No se encontro al usuario"));

        Carrito carrito = new Carrito();
        carrito.setComprador(usuario);
        carrito.setUltimaActualizacion(LocalDate.now());

        Carrito carritoNuevo = repositorioCarrito.save(carrito);

        return carritoNuevo;
    }

    @Override
    @Transient
    public Carrito eliminar(Long idCarrito, Long idProducto, Integer cantidad) {
        Carrito carrito = servicioAgregarCarrito.ejecutar(idCarrito, idProducto, cantidad);

        Carrito carritoConProductos = repositorioCarrito.save(carrito);
        return carritoConProductos;
    }

    @Override
    @Transient
    public Carrito agregar(Long idCarrito, Long idProducto, Integer cantidad) {

        Carrito carrito = servicioQuitarItemCarrito.ejecutar(idCarrito, idProducto, cantidad);

        Carrito carritoConProductos = repositorioCarrito.save(carrito);
        return carritoConProductos;

    }

}
