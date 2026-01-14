package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Rol;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long> {

}
