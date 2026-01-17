package com.example.ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.Model.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM producto p WHERE p.categoria.nombre = :nombre")
    List<Producto> buscarSubCategoria(@Param("nombre") String nombre);
    

    @Query("SELECT p FROM producto p WHERE p.categoria.categoriaPadre.nombre = :nombre")
    List<Producto> buscarPorCategoriaPadre(@Param("nombre") String nombre);
    @Query("SELECT p FROM producto p ORDER BY p.precio Asc")
    List<Producto> productosPorPrecioMin();
    @Query("SELECT p FROM producto p ORDER BY p.precio Desc")
    List<Producto> productosPorPrecioMax();

}
