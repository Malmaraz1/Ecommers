package com.example.mvsc.servicio_control_stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvsc.servicio_control_stock.Model.Deposito;

public interface RepositorioDeposito extends JpaRepository<Deposito,Long> {
    
}
