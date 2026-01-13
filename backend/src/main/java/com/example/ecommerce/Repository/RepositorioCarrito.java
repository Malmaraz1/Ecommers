package com.example.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Model.Carrito;

public interface RepositorioCarrito extends JpaRepository<Carrito,Long> {

    
    
}
