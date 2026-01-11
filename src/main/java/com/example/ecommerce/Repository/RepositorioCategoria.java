package com.example.ecommerce.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Model.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria,Long> {
    
}
