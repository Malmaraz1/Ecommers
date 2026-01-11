package com.example.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Model.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido,Long> {
    
}
