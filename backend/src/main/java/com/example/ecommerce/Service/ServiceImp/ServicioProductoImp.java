package com.example.ecommerce.Service.ServiceImp;

import java.util.List;
import java.util.Optional;


import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Model.Dto.Request.ProductoRequestDto;


public interface ServicioProductoImp {
List<Producto> findAll();    
Producto save(ProductoRequestDto productoDto);
Optional<Producto> findById(Long id);
List<Producto> findByCategoria(Categoria categoria);
List<Producto> findBySubCategoria(Categoria categoria);
List<Producto> findByPrecioMax();
List<Producto> findByPrecioMin();
Optional<Producto> delete(Long id);

}
