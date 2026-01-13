package com.example.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.Model.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {

}
