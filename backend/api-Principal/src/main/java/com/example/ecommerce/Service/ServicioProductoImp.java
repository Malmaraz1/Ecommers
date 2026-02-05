package com.example.ecommerce.Service;

import java.time.LocalDate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.ecommerce.Dto.Filtros;
import com.example.ecommerce.Dto.ProductoDto;
import com.example.ecommerce.Dto.StockDto;
import com.example.ecommerce.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Repository.RepositorioCategoria;
import com.example.ecommerce.Repository.RepositorioProducto;
import com.example.ecommerce.Service.ServiceImp.ServicioProducto;
import com.example.ecommerce.clients.StockClientRest;
import com.example.ecommerce.exceptions.AlreadyExistsException;
import com.example.ecommerce.exceptions.NotFoundException;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.validation.Valid;

@Service
public class ServicioProductoImp implements ServicioProducto {

    @Autowired
    RepositorioProducto repositorioProducto;
    @Autowired
    RepositorioCategoria repositorioCategoria;
    @Autowired
    StockClientRest stockClientRest;

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
                        "La categoría con id " + productoDto.getCategoria_id() + " no existe"));

        if (repositorioProducto.existsByNombre(productoDto.getNombre())) {
            throw new AlreadyExistsException("Ya existe un producto con el nombre: " + productoDto.getNombre());
        }
        System.out.print(productoDto);
        Producto producto = new Producto();

        producto.setNombre(productoDto.getNombre());
        producto.setFechaCreacion(LocalDate.now());
        producto.setModelo(productoDto.getModelo());
        producto.setCategoria(categoria);
        producto.setPrecio(productoDto.getPrecio());
        producto.setDescripcion_productro(productoDto.getDescripcion());
        if (productoDto.getImg() == null || productoDto.getImg().isEmpty()) {
            producto.setImagen("https://tusitio.com/default-placeholder.png");
        } else {
            producto.setImagen(productoDto.getImg());
        }

        producto.setMarca(productoDto.getMarca());

        Producto productoDb = repositorioProducto.save(producto);

        StockDto stockDto = new StockDto();
        stockDto.setProducto_id(productoDb.getId());
        stockDto.setDeposito_id((long) 1);
        stockClientRest.crear(stockDto);

        return new ProductoDto(productoDb);

    }

    @Override
    @Transactional
    public void eliminarProducto(Long id) {

        Producto producto = repositorioProducto.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el producto con id  " + id));

        repositorioProducto.delete(producto);
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
                .orElseThrow(() -> new NotFoundException("El producto con id " + idProducto + " no existe"));

        p.actualizarProducto(productoRequestDto);

        return new ProductoDto(repositorioProducto.save(p));

    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductoDto> filtros(Filtros filtro, Pageable pageable) {

        Specification<Producto> spec = Specification.where(null);

        if (filtro.getPrecioMin() != null) {
            spec = spec.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("precio"), filtro.getPrecioMin()));
        }

        if (filtro.getPrecioMax() != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("precio"), filtro.getPrecioMax()));
        }

        spec = spec.and((root, query, cb) -> {

            Join<Producto, Categoria> catJoin = root.join("categoria");

            Join<Categoria, Categoria> padreJoin = catJoin.join("categoriaPadre", JoinType.LEFT);

            return cb.or(
                    cb.equal(catJoin.get("nombre"), filtro.getCategoria()),
                    cb.equal(padreJoin.get("nombre"), filtro.getCategoria()));
        });
        Page<Producto> productosPage = repositorioProducto.findAll(spec, pageable);

        if (productosPage.isEmpty()) {
            throw new NotFoundException("No se encontraron productos con los filtros aplicados!!");
        }

        return productosPage.map(producto -> new ProductoDto(
                producto));

    }

}
