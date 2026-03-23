package com.example.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.Model.Carrito;

public interface RepositorioCarrito extends JpaRepository<Carrito,Long> {
   @Query("SELECT c FROM carrito c " +
            "LEFT JOIN FETCH c.itemsCarrito ic " +
            "LEFT JOIN FETCH ic.producto " +
            "WHERE c.id = :id")
    Optional<Carrito> findCarritoFull(@Param("id") Long id);
    
    
}
