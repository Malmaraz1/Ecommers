package com.example.mvsc.servicio_control_stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvsc.servicio_control_stock.Model.Stock;

public interface RepositorioStock extends JpaRepository<Stock,Long> {
    
}
