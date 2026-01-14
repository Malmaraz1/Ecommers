package com.example.ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Model.Producto;

import com.example.ecommerce.Service.ServiceImp.ServicioProductoImp;

@RestController
@RequestMapping("/productos")
public class ControllerProducto {
    @Autowired
    ServicioProductoImp servicioProducto;

    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody ProductoRequestDto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioProducto.guardarProducto(producto));
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> findByEntity(@PathVariable Long idProducto) {
        Optional<Producto> producto = servicioProducto.buscarProducto(idProducto);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @GetMapping()
    public ResponseEntity<List<Producto>> findAllProduct() {
        List<Producto> productosDto = servicioProducto.todosLosProductos();
        if (productosDto.isEmpty()) {
            throw new RuntimeException("No se encontrar productos");
        }
        return ResponseEntity.ok(productosDto);

    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> delete(@PathVariable Long idProducto) {
        servicioProducto.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }

}
