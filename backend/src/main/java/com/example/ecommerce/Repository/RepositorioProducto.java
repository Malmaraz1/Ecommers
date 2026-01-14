package com.example.ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ecommerce.Model.Producto;


@Repository
public interface RepositorioProducto  extends JpaRepository<Producto,Long>{
    
   List<Producto> findByCategoria_Nombre(String nombre);

    // Si quieres buscar productos por el nombre de la "Categoría Padre" de su categoría
    List<Producto> findByCategoria_CategoriaPadre_Nombre(String nombrePadre);

    List<Producto> findFirstByOrderByPrecioDesc();

    List<Producto> findFirstByOrderByPrecioAsc();
    
}
