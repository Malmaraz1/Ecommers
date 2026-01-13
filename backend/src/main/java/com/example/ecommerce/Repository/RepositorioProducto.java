package com.example.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.Model.Producto;


@Repository
public interface RepositorioProducto  extends JpaRepository<Producto,Long>{

    
}
