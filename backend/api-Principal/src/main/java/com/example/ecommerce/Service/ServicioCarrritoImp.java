package com.example.ecommerce.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Dto.CarritoDto;
import com.example.ecommerce.Dto.StockDto;
import com.example.ecommerce.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Carrito;

import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Repository.RepositorioCarrito;

import com.example.ecommerce.Repository.RepositorioUsuario;
import com.example.ecommerce.Service.ServiceImp.ServicioCarrito;
import com.example.ecommerce.clients.StockClientRest;
import com.example.ecommerce.exceptions.NotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioCarrritoImp implements ServicioCarrito {

    private final RepositorioCarrito repositorioCarrito;
    private final RepositorioUsuario repositorioUsuario;
    private final StockClientRest stockClientRest;
    private final ServicioAgregarCarrito servicioAgregarCarrito;
    private final ServicioQuitarItemCarrito servicioQuitarItemCarrito;

    @Override
    @Transactional
    public CarritoDto crear(CarritoRequestDto carritoRequestDto) {

        Usuario usuario = repositorioUsuario.findById(carritoRequestDto.getUsuario_id())
                .orElseThrow(() -> new NotFoundException("No se encontro al usuario"));

        Carrito carrito = new Carrito();
        carrito.setComprador(usuario);
        carrito.setUltimaActualizacion(LocalDate.now());

        Carrito carritoNuevo = repositorioCarrito.save(carrito);

        CarritoDto carritoDto = new CarritoDto();
        carritoDto.setComprador_id(carritoNuevo.getComprador().getId());
        carritoDto.setId(carritoNuevo.getId());
        carritoDto.setItemsCarrito(carritoNuevo.getItemsCarrito());

        return carritoDto;
    }

    @Override
    @Transactional
    public CarritoDto quitarProducto(Long idCarrito, Long idProducto, Integer cantidad) {
        Carrito carrito = servicioQuitarItemCarrito.ejecutar(idCarrito, idProducto, cantidad);
        CarritoDto carritoDto = new CarritoDto();
        carritoDto.setComprador_id(carrito.getComprador().getId());
        carritoDto.setId(carrito.getId());
        carritoDto.setItemsCarrito(carrito.getItemsCarrito());

        return carritoDto;
    }

    @Override
    @Transactional
    public CarritoDto agregar(Long idCarrito, Long idProducto, Integer cantidad) {

        StockDto stockDto = stockClientRest.detalle(idProducto);

        if (stockDto.getCantidad() > 0) {
         throw new RuntimeException("No hay stock del producto");
        }
        Carrito carrito = servicioAgregarCarrito.ejecutar(idCarrito, idProducto, cantidad);
        CarritoDto carritoDto = new CarritoDto();
        carritoDto.setComprador_id(carrito.getComprador().getId());
        carritoDto.setId(carrito.getId());
        carritoDto.setItemsCarrito(carrito.getItemsCarrito());

        return carritoDto;

    }

}
