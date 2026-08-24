package com.example.ecommerce.Service.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ecommerce.Model.Rol;
import com.example.ecommerce.Repository.RepositorioRol;

@Component
public class DataInitializer implements CommandLineRunner {

    
    public DataInitializer(RepositorioRol rolRepository) {
        this.rolRepository = rolRepository;
    }

    private RepositorioRol rolRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!rolRepository.existsByName("ROLE_USER")) {

            Rol rol = new Rol();
            rol.setName("ROLE_USER");
            rolRepository.save(rol);
        }
        if (!rolRepository.existsByName("ROLE_ADMIN")) {
            Rol adminRol = new Rol();
            adminRol.setName("ROLE_ADMIN");
            rolRepository.save(adminRol);
        }
    }
}
