package com.example.ecommerce.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.jdbc.Expectation.OutParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.Controller.ControllerProducto;
import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;

import com.example.ecommerce.Repository.RepositorioProducto;
import com.example.ecommerce.Service.ServiceImp.ServicioProductoImp;


import jakarta.validation.Valid;

@Service
public class ServicioProducto implements ServicioProductoImp {

    @Autowired
    RepositorioProducto repositorioProducto;

    @Override
    public List<Producto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    @Transactional
    public Producto save(@Valid ProductoRequestDto productoDto) {
        Producto producto = new Producto();
        producto.setCategoria(productoDto.getCategoria());
        producto.setNombre(productoDto.getNombre());
        producto.setFechaCreacion(LocalDate.now());
        producto.setModelo(productoDto.getModelo());

        Producto productoBd = repositorioProducto.save(producto);
        
        return productoBd;
    }

    @Override
    public Optional<Producto> findById(Long id) {
        Optional<Producto> producto = repositorioProducto.findById(id);

        if (producto.isEmpty()) {
            throw new RuntimeException("producto no encontrado");
        }
        return producto;

    }

    @Override
    public List<Producto> findByCategoria(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCategoria'");
    }

    @Override
    public List<Producto> findBySubCategoria(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBySubCategoria'");
    }

    @Override
    public List<Producto> findByPrecioMax() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrecioMax'");
    }

    @Override
    public List<Producto> findByPrecioMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrecioMin'");
    }

    @Override
    @Transactional
    public Optional<Producto> delete(Long id) {
        Optional<Producto> producto = repositorioProducto.findById(id);
       producto.ifPresent(p -> {
        repositorioProducto.delete(p);
       });
       return producto;
    }

}
