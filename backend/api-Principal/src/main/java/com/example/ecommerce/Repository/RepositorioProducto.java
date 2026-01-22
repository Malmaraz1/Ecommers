package com.example.ecommerce.Repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.Model.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM producto p WHERE p.categoria.nombre = :nombre")
    Page<Producto> buscarSubCategoria(@Param("nombre") String nombre,Pageable pageable);

    @Query("SELECT p FROM producto p WHERE p.categoria.categoriaPadre.nombre = :nombre")
    Page<Producto> buscarPorCategoriaPadre(@Param("nombre") String nombre ,Pageable pageable);

    @Query("SELECT p FROM producto p ORDER BY p.precio Asc")
    Page<Producto> productosPorPrecioMin(Pageable pageable);

    @Query("SELECT p FROM producto p ORDER BY p.precio Desc")
    Page<Producto> productosPorPrecioMax(Pageable pageable);

    boolean existsByNombre(String nombre);

}
