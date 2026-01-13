package com.example.ecommerce.Controller;

import java.util.Optional;

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

import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Carrito;

import com.example.ecommerce.Service.ServiceImp.ServicioCarritoImp;



@RestController
@RequestMapping("/carritos")
public class ControllerCarrito {

  @Autowired
  ServicioCarritoImp servicioCarrito;

  @PostMapping
  public ResponseEntity<Carrito> nuevoCarrito(@RequestBody CarritoRequestDto carrito) {
    return ResponseEntity.status(HttpStatus.CREATED).body(servicioCarrito.crear(carrito));

  }

  @PatchMapping("{idCarrito}/productos/{idproducto}/item_carrito")
  public ResponseEntity<Carrito> agregarproducto(@PathVariable Long idProducto ,@PathVariable Long idcarrito ,@RequestParam Integer cantidad ) {
    Carrito actualizado = servicioCarrito.agregar(idcarrito , idProducto,cantidad);
    return ResponseEntity.ok(actualizado);
  }

  @DeleteMapping("{idCarrito}/productos/{idproducto}")
  public ResponseEntity<?> quitarProducto(@PathVariable Long idproducto , @PathVariable Long idcarrito ,@RequestParam Integer cantidad) {
    Carrito carritoOptional = servicioCarrito.eliminar(idcarrito,idproducto,cantidad);
    if (carritoOptional != null) {
      return ResponseEntity.status(HttpStatus.OK).build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

  }
  

}
