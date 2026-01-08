package com.example.ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Model.Dto.ProductoResponseDto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Service.ServicioProductoImp;

@RestController
@RequestMapping("/")
public class ControllerProducto {
    @Autowired
    ServicioProductoImp servicioProducto;

    @PostMapping("producto")

    public ResponseEntity<ProductoResponseDto> create(@RequestBody ProductoRequestDto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioProducto.save(producto));
    }

    @GetMapping("productos/{idProducto}")
    public ResponseEntity<ProductoResponseDto> findByEntity(@PathVariable Long idProducto) {
        Optional<ProductoResponseDto> producto = servicioProducto.findById(idProducto);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @GetMapping("/productos")
    public ResponseEntity<List<ProductoResponseDto>> findAllProduct() {
        List<ProductoResponseDto> productosDto = servicioProducto.findAll();
        if (productosDto.isEmpty()) {
            throw new RuntimeException("No se encontrar productos");
        }
        return ResponseEntity.ok(productosDto);
        

    }



}
