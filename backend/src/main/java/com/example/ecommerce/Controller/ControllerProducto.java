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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Model.Dto.ProductoDto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;

import com.example.ecommerce.Service.ServiceImp.ServicioProductoImp;
import com.example.ecommerce.exceptions.NotFoundException;

@RestController
@RequestMapping("/productos")
public class ControllerProducto {
    @Autowired
    ServicioProductoImp servicioProducto;

    @PostMapping()
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoRequestDto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioProducto.guardarProducto(producto));
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<ProductoDto> findByEntity(@PathVariable Long idProducto) {
        Optional<ProductoDto> producto = servicioProducto.buscarProducto(idProducto);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @GetMapping()
    public ResponseEntity<List<ProductoDto>> findAllProduct() {
        List<ProductoDto> productosDto = servicioProducto.todosLosProductos();
        if (productosDto.isEmpty()) {
            throw new NotFoundException("No se encontraron productos en la base de datos");
        }
        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/filtro")
    public ResponseEntity<List<ProductoDto>> productosPorCategoria(
            @RequestParam(name = "categoria", required = false) String nombreCategoria) {
        List<ProductoDto> productosDto = servicioProducto.productosPorCategoria(nombreCategoria);

        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/filtroSub")
    public ResponseEntity<List<ProductoDto>> productosPorSubCategoria(
            @RequestParam(name = "categoria", required = false) String nombreSubCategoria) {
        List<ProductoDto> productosDto = servicioProducto.productosPorSubCategoria(nombreSubCategoria);

        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/maximo")
    public ResponseEntity<List<ProductoDto>> productosPorPrecioMax() {
        List<ProductoDto> productosDto = servicioProducto.productosPorPrecioMax();
        if (productosDto.isEmpty()) {
            throw new NotFoundException("No se encontraron productos en la base de datos");
        }
        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/minimo")
    public ResponseEntity<List<ProductoDto>> productoPorPrecioMin() {
        List<ProductoDto> productosDto = servicioProducto.productoPorPrecioMin();
        if (productosDto.isEmpty()) {
            throw new NotFoundException("No se encontraron productos en la base de datos");
        }
        return ResponseEntity.ok(productosDto);

    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> delete(@PathVariable Long idProducto) {
        servicioProducto.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }

}
