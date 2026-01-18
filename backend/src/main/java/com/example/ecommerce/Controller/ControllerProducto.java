package com.example.ecommerce.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<ProductoDto>> findAllProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<ProductoDto> productosDto = servicioProducto.todosLosProductos(PageRequest.of(page, size));

        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/filtro")
    public ResponseEntity<Page<ProductoDto>> productosPorCategoria(
            @RequestParam(name = "categoria", required = false) String nombreCategoria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductoDto> productosDto = servicioProducto.productosPorCategoria(nombreCategoria, pageable);

        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/filtroSub")
    public ResponseEntity<Page<ProductoDto>> productosPorSubCategoria(
            @RequestParam(name = "categoria", required = false) String nombreSubCategoria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductoDto> productosDto = servicioProducto.productosPorSubCategoria(nombreSubCategoria, pageable);

        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/maximo")
    public ResponseEntity<Page<ProductoDto>> productosPorPrecioMax(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductoDto> productosDto = servicioProducto.productosPorPrecioMax(pageable);

        return ResponseEntity.ok(productosDto);

    }

    @GetMapping("/minimo")
    public ResponseEntity<Page<ProductoDto>> productoPorPrecioMin(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductoDto> productosDto = servicioProducto.productoPorPrecioMin(pageable);

        return ResponseEntity.ok(productosDto);

    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> delete(@PathVariable Long idProducto) {
        servicioProducto.eliminarProducto(idProducto);
        return ResponseEntity.noContent().build();
    }

}
