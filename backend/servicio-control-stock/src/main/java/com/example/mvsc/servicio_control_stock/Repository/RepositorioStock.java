package com.example.mvsc.servicio_control_stock.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mvsc.servicio_control_stock.Model.Stock;

public interface RepositorioStock extends JpaRepository<Stock, Long> {
    
   Optional<Stock> findByProductoId(Long productoId);

}
