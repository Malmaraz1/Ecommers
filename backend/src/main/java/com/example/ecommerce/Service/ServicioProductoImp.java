package com.example.ecommerce.Service;

import java.time.LocalDate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Dto.ProductoDto;
import com.example.ecommerce.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Repository.RepositorioCategoria;
import com.example.ecommerce.Repository.RepositorioProducto;
import com.example.ecommerce.Service.ServiceImp.ServicioProducto;
import com.example.ecommerce.exceptions.AlreadyExistsException;
import com.example.ecommerce.exceptions.NotFoundException;

import jakarta.validation.Valid;

@Service
public class ServicioProductoImp implements ServicioProducto {

    @Autowired
    RepositorioProducto repositorioProducto;
    @Autowired
    RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDto> todosLosProductos(Pageable pageable) {
        Page<Producto> productos = repositorioProducto.findAll(pageable);

        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron productos");
        }

        return productos.map(producto -> new ProductoDto(
                producto));
    }

    @Override
    @Transactional
    public ProductoDto guardarProducto(@Valid ProductoRequestDto productoDto) {

        Categoria categoria = repositorioCategoria.findById(productoDto.getCategoria_id())
                .orElseThrow(() -> new NotFoundException(
                        "La categoría con ID " + productoDto.getCategoria_id() + " no existe"));

        if (repositorioProducto.existsByNombre(productoDto.getNombre())) {
            new AlreadyExistsException("Ya existe un producto con el nombre: " + productoDto.getNombre());
        }

        Producto producto = new Producto();

        producto.setNombre(productoDto.getNombre());
        producto.setFechaCreacion(LocalDate.now());
        producto.setModelo(productoDto.getModelo());
        producto.setCategoria(categoria);
        producto.setPrecio(productoDto.getPrecio());
        producto.setDescripcion_productro(productoDto.getDescripcion());
        producto.setImagen(null);
        producto.setMarca(productoDto.getMarca());

        Producto productoDb = repositorioProducto.save(producto);

        return new ProductoDto(productoDb);

    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDto> productosPorCategoria(String nombreCat, Pageable pageable) {
        Page<Producto> productos = repositorioProducto.buscarPorCategoriaPadre(nombreCat, pageable);
        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron categorias para este producto service");
        }
        return productos.map(producto -> new ProductoDto(
                producto));

    }

    @Override
    @Transactional
    public void eliminarProducto(Long id) {

        Producto producto = repositorioProducto.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el producto con id " + id));

        repositorioProducto.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDto> productosPorSubCategoria(String categoria, Pageable pageable) {

        System.out.println(categoria);
        Page<Producto> productos = repositorioProducto.buscarSubCategoria(categoria, pageable);
        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron subCategorias para este producto service");
        }
        return productos.map(producto -> new ProductoDto(
                producto));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDto> productosPorPrecioMax(Pageable pageable) {
        Page<Producto> productos = repositorioProducto.productosPorPrecioMax(pageable);
        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron  productos");
        }

        return productos.map(producto -> new ProductoDto(
                producto));

    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDto> productoPorPrecioMin(Pageable pageable) {
        Page<Producto> productos = repositorioProducto.productosPorPrecioMin(pageable);
        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron  productos");
        }

        return productos.map(producto -> new ProductoDto(
                producto));

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoDto> buscarProducto(Long idProducto) {
        return repositorioProducto.findById(idProducto).map(
                p -> {
                    return new ProductoDto(p);
                });

    }

    @Override
    @Transactional
    public ProductoDto editarProducto(Long idProducto, ProductoRequestDto productoRequestDto) {

        Producto p = repositorioProducto.findById(idProducto)
                .orElseThrow(() -> new NotFoundException("El producto con ID " + idProducto + " no existe"));

        p.actualizarProducto(productoRequestDto);

        return new ProductoDto(repositorioProducto.save(p));

    }

}
