package com.example.ecommerce.Service.ServiceImp;

import java.util.List;
import java.util.Optional;


import com.example.ecommerce.Model.Dto.ProductoDto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;


public interface ServicioProductoImp {
List<ProductoDto> todosLosProductos();    
ProductoDto guardarProducto(ProductoRequestDto productoDto);
List<ProductoDto> productosPorCategoria(String categoria);
List<ProductoDto> productosPorSubCategoria(String categoria);
List<ProductoDto> productosPorPrecioMax();
List<ProductoDto> productoPorPrecioMin();
void  eliminarProducto(Long id);
Optional<ProductoDto> buscarProducto(Long idProducto);

}
