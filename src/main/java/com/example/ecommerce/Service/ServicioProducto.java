package com.example.ecommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Model.Dto.Response.ProductoResponseDto;
import com.example.ecommerce.Service.ServiceImp.ServicioProductoImp;
@Service
public class ServicioProducto implements ServicioProductoImp{

    @Override
    public List<ProductoResponseDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ProductoResponseDto save(ProductoRequestDto productoDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<ProductoResponseDto> delete(ProductoRequestDto producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<ProductoResponseDto> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<ProductoResponseDto> findByCategoria(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCategoria'");
    }

    @Override
    public List<ProductoResponseDto> findBySubCategoria(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBySubCategoria'");
    }

    @Override
    public List<ProductoResponseDto> findByPrecioMax() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrecioMax'");
    }

    @Override
    public List<ProductoResponseDto> findByPrecioMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPrecioMin'");
    }

   
    


    
}
