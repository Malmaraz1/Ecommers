package com.example.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Model.Factura;


public interface RepositorioFactura extends JpaRepository<Factura,Long> {

        
}
