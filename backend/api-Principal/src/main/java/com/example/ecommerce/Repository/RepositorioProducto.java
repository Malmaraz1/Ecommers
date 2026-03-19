package com.example.ecommerce.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

import com.example.ecommerce.Model.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

    boolean existsByNombre(String nombre);

    @Override
    @EntityGraph(attributePaths = { "categoria", "categoria.categoriaPadre" })
    Page<Producto> findAll(Pageable pageable);

    // 2. Arregla el N+1 para tu método de FILTROS (Specification)
    @Override
    @EntityGraph(attributePaths = { "categoria", "categoria.categoriaPadre" })
    Page<Producto> findAll(Specification<Producto> spec, Pageable pageable);

}
