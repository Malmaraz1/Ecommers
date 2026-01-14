package com.example.ecommerce.Service.ServiceImp;

import java.util.List;
import java.util.Optional;



import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;


public interface ServicioProductoImp {
List<Producto> todosLosProductos();    
Producto guardarProducto(ProductoRequestDto productoDto);
Optional<Producto> buscarProducto(Long id);
List<Producto> productosPorCategoria(String categoria);
List<Producto> productosPorSubCategoria(String categoria);
List<Producto> productosPorPrecioMax();
List<Producto> productoPorPrecioMin();
Optional<Producto> eliminarProducto(Long id);

}
