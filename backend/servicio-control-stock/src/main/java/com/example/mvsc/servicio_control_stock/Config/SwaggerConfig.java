package com.example.mvsc.servicio_control_stock.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI stockOpenAPI() {
        return new OpenAPI()
                // Le decimos a Swagger que cualquier petición pase por el Gateway en /api/v1/stock
                .servers(List.of(
                        new Server().url("/api/v1/stock").description("Nginx Gateway - Stock Service")
                ))
                .info(new Info()
                        .title("Stock Service API")
                        .version("1.0")
                        .description("Microservicio de gestión de stock e inventario"));
    }
    
}