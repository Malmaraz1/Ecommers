package com.example.ecommerce.Service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Producto;

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
    public List<Producto> todosLosProductos() {

        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    @Transactional
    public Producto guardarProducto(@Valid ProductoRequestDto productoDto) {

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

        Producto productoBd = repositorioProducto.save(producto);

        return productoBd;
    }

    @Override
    public List<Producto> productosPorCategoria(String categoria) {
        return repositorioProducto.findByCategoria_Nombre(categoria);
    }

    @Override
    @Transactional
    public Optional<Producto> eliminarProducto(Long id) {
        Optional<Producto> producto = repositorioProducto.findById(id);
        producto.ifPresent(p -> {
            repositorioProducto.delete(p);
        });
        return producto;
    }

    @Override
    public Optional<Producto> buscarProducto(Long id) {
        return repositorioProducto.findById(id);

    }

    @Override
    public List<Producto> productosPorSubCategoria(String categoria) {
        return repositorioProducto.findByCategoria_CategoriaPadre_Nombre(categoria);

    }

    @Override
    public List<Producto> productosPorPrecioMax() {
        return repositorioProducto.findFirstByOrderByPrecioDesc();

    }

    @Override
    public List<Producto> productoPorPrecioMin() {
        return repositorioProducto.findFirstByOrderByPrecioAsc();

    }

}
