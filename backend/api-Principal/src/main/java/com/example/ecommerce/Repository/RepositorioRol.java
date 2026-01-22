package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Rol;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long> {
   
    Optional<Rol> findByName(String nombre);
}
