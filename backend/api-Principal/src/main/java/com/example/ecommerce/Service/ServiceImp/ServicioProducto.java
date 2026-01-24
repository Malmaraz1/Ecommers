package com.example.ecommerce.Service.ServiceImp;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.ecommerce.Dto.Filtros;
import com.example.ecommerce.Dto.ProductoDto;
import com.example.ecommerce.Dto.Request.ProductoRequestDto;




public interface ServicioProducto {
ProductoDto guardarProducto(ProductoRequestDto productoDto);
void  eliminarProducto(Long id);
Optional<ProductoDto> buscarProducto(Long idProducto);
Page<ProductoDto> todosLosProductos(Pageable pageable);
ProductoDto editarProducto(Long idProducto , ProductoRequestDto productoRequestDto);
Page<ProductoDto> filtros(Filtros filtro, Pageable pageable);
}
