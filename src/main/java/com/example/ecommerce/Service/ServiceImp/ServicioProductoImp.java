package com.example.ecommerce.Service.ServiceImp;

import java.util.List;
import java.util.Optional;


import com.example.ecommerce.Model.Categoria;

import com.example.ecommerce.Model.Dto.ProductoResponseDto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;

public interface ServicioProductoImp {
List<ProductoResponseDto> findAll();    
ProductoResponseDto save(ProductoRequestDto productoDto);
Optional<ProductoResponseDto> delete(ProductoRequestDto producto);
Optional<ProductoResponseDto> findById(Long id);
List<ProductoResponseDto> findByCategoria(Categoria categoria);
List<ProductoResponseDto> findBySubCategoria(Categoria categoria);
List<ProductoResponseDto> findByPrecioMax();
List<ProductoResponseDto> findByPrecioMin();
}
