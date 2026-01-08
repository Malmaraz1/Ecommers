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
import org.springframework.web.bind.annotation.RestController;
import com.example.ecommerce.Model.Dto.CarritoResponseDto;
import com.example.ecommerce.Model.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Service.ServidorCarritoImp;

@RestController
@RequestMapping("/")
public class ControllerCarrito {

  @Autowired
  ServidorCarritoImp servicioCarrito;

  @PostMapping("/carrito")
  public ResponseEntity<CarritoResponseDto> create(@RequestBody CarritoRequestDto carrito) {
    return ResponseEntity.status(HttpStatus.CREATED).body(servicioCarrito.guardar(carrito));

  }

  @PatchMapping("carrito/productos/{idproducto}")
  public ResponseEntity<CarritoResponseDto> agregarproducto(@PathVariable Long idProducto) {
    CarritoResponseDto actualizado = servicioCarrito.agregar(idProducto);
    return ResponseEntity.ok(actualizado);
  }

  @DeleteMapping("carrito/productos/{idproducto}")
  public ResponseEntity<?> quitarProducto(@PathVariable Long idProducto) {
    Optional<CarritoResponseDto> carritoOptional = servicioCarrito.eliminar(idProducto);
    if (carritoOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

  }

}
