package com.example.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Dto.CarritoDto;
import com.example.ecommerce.Dto.Request.CarritoRequestDto;


import com.example.ecommerce.Service.ServiceImp.ServicioCarrito;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carritos")
public class ControllerCarrito {

  @Autowired
  ServicioCarrito servicioCarrito;

  @PostMapping
  public ResponseEntity<CarritoDto> nuevoCarrito(@Valid @RequestBody CarritoRequestDto carrito) {

    return ResponseEntity.status(HttpStatus.CREATED).body(servicioCarrito.crear(carrito));

  }

  @PatchMapping("/{idCarrito}/productos/{idProducto}/item_carrito")
  public ResponseEntity<CarritoDto> agregarproducto(@Valid @PathVariable("idCarrito") Long idCarrito, @PathVariable("idProducto") Long idProducto,
      @RequestParam Integer cantidad) {
    CarritoDto actualizado = servicioCarrito.agregar(idCarrito, idProducto, cantidad);
    return ResponseEntity.ok(actualizado);
  }

  @DeleteMapping("/{idCarrito}/productos/{idproducto}")
  public ResponseEntity<?> quitarProducto(@Valid @PathVariable Long idproducto, @PathVariable Long idcarrito,
      @RequestParam Integer cantidad) {
    CarritoDto carritoOptional = servicioCarrito.quitarProducto(idcarrito, idproducto, cantidad);
    if (carritoOptional != null) {
      return ResponseEntity.status(HttpStatus.OK).build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

  }

}
