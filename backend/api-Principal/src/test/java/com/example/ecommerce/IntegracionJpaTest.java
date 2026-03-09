package com.example.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Repository.RepositorioProducto;

@DataJpaTest

public class IntegracionJpaTest {

    @Autowired
    RepositorioProducto repositorioProducto;
     

    @Test
    void testFindById(){
    Optional<Producto> productoDto = repositorioProducto.findById(1L);
    assertTrue(productoDto.isPresent()); 
    }
    @Test
    void testFindByName(){
    boolean productoDto = repositorioProducto.existsByNombre("Teclado Mecánico");
     assertTrue(productoDto);
     
    }
    
}
