package com.example.ecommerce.Service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Model.Dto.ProductoDto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Repository.RepositorioCategoria;
import com.example.ecommerce.Repository.RepositorioProducto;
import com.example.ecommerce.Service.ServiceImp.ServicioProductoImp;
import com.example.ecommerce.exceptions.NotFoundException;

import jakarta.validation.Valid;

@Service
public class ServicioProducto implements ServicioProductoImp {

    @Autowired
    RepositorioProducto repositorioProducto;
    @Autowired
    RepositorioCategoria repositorioCategoria;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDto> todosLosProductos() {
        List<Producto> productos = repositorioProducto.findAll();

         if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron productos");
        }
        
          return productos.stream().map(ProductoDto::new)
                .toList();
    }

    @Override
    @Transactional
    public ProductoDto guardarProducto(@Valid ProductoRequestDto productoDto) {

        Categoria categoria = repositorioCategoria.findById(productoDto.getCategoria_id())
                .orElseThrow(() -> new NotFoundException(
                        "La categoría con ID " + productoDto.getCategoria_id() + " no existe"));

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
    public List<ProductoDto> productosPorCategoria(String nombreCat) {
        List<Producto> productos = repositorioProducto.buscarPorCategoriaPadre(nombreCat);
          if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron categorias para este producto service");
        }
        return productos.stream().map(ProductoDto::new)
                .toList();
    }

    @Override
    @Transactional
    public void eliminarProducto(Long id) {
        Optional<Producto> producto = repositorioProducto.findById(id);
        producto.ifPresent(p -> {
            repositorioProducto.delete(p);
        });

    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDto> productosPorSubCategoria(String categoria) {

        System.out.println(categoria);
        List<Producto> productos = repositorioProducto.buscarSubCategoria(categoria);
        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron subCategorias para este producto service");
        }
        return productos.stream().map(ProductoDto::new)
                .toList();
    }

    @Override
    public List<ProductoDto> productosPorPrecioMax() {
        List<Producto> productos = repositorioProducto.productosPorPrecioMax();
        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron  productos");
        }

        return productos.stream().map(ProductoDto::new)
                .toList();

    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDto> productoPorPrecioMin() {
        List<Producto> productos = repositorioProducto.productosPorPrecioMin();
        if (productos.isEmpty()) {
            throw new NotFoundException("no se encontraron  productos");
        }

        return productos.stream().map(ProductoDto::new)
                .toList();

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoDto> buscarProducto(Long idProducto) {
        return repositorioProducto.findById(idProducto).map(
                p -> {
                    return new ProductoDto(p);
                });

    }

}
