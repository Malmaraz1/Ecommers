package com.example.ecommerce.Service.ServiceImp;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.ecommerce.Model.Dto.ProductoDto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;


public interface ServicioProductoImp {

ProductoDto guardarProducto(ProductoRequestDto productoDto);
Page<ProductoDto> productosPorCategoria(String categoria,Pageable pageable);
Page<ProductoDto> productosPorSubCategoria(String categoria,Pageable pageable);
Page<ProductoDto> productosPorPrecioMax(Pageable pageable);
Page<ProductoDto> productoPorPrecioMin(Pageable pageable);
void  eliminarProducto(Long id);
Optional<ProductoDto> buscarProducto(Long idProducto);
Page<ProductoDto> todosLosProductos(Pageable pageable);

}
