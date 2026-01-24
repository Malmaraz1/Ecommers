package com.example.ecommerce.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-commerce API")
                        .version("1.0")
                        .description("Documentación de la API. Para probar los endpoints protegidos: \n" +
                                     "1. Usar el endpoint de /login con credenciales válidas.\n" +
                                     "2. Copiar el token generado.\n" +
                                     "3. Pegarlo en el botón 'Authorize' de arriba."))
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                // --- AGREGAMOS EL ENDPOINT DE LOGIN MANUALMENTE ---
                .path("/login", new PathItem()
                        .post(new Operation()
                                .summary("Login de Usuario")
                                .description("Envía username y password para obtener el token JWT.")
                                .tags(List.of("Autenticación"))
                                .requestBody(new RequestBody()
                                        .content(new Content().addMediaType("application/json",
                                                new MediaType().schema(new Schema<>()
                                                        .addProperty("nombre", new Schema<>().type("string").example("admin"))
                                                        .addProperty("contrasenia", new Schema<>().type("string").example("123456"))))))
                                .responses(new ApiResponses()
                                        .addApiResponse("200", new ApiResponse().description("Login exitoso. El token se encuentra en el Body o Header.")))));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
