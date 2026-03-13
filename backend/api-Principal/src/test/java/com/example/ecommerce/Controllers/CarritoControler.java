package com.example.ecommerce.Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.ecommerce.Controller.ControllerCarrito;
import com.example.ecommerce.Dto.CarritoDto;
import com.example.ecommerce.Dto.Request.CarritoRequestDto;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Service.ServicioCarrritoImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(ControllerCarrito.class)
@AutoConfigureMockMvc(addFilters = false)
public class CarritoControler {
  @Autowired
    private MockMvc mvc;

    // 1. Inyectamos ObjectMapper para convertir objetos Java a JSON
    @Autowired
    private ObjectMapper objectMapper; 

    @MockitoBean
    private ServicioCarrritoImp servicioCarrritoImp;

    @Test
    void crearCarrito() throws Exception {

        // Arrange: Preparamos los datos
        CarritoDto carrito = new CarritoDto();
        carrito.setId(1L);
        carrito.setComprador_id(1L);

        CarritoRequestDto carritoRequestDto = new CarritoRequestDto(1L);

        // Usamos any() para evitar fallos si el DTO no tiene implementado el método equals()
        when(servicioCarrritoImp.crear(any(CarritoRequestDto.class))).thenReturn(carrito);

        // Act & Assert: Ejecutamos y verificamos
        mvc.perform(MockMvcRequestBuilders.post("/carritos")
                .contentType(MediaType.APPLICATION_JSON)
                // 2. Pasamos el DTO convertido a JSON en el 'content'
                .content(objectMapper.writeValueAsString(carritoRequestDto))) 
                
                // 3. Verificamos el estado (isCreated (201) o isOk (200) según tu controlador)
                .andExpect(status().isCreated()) 
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                
                // 4. Verificamos que el JSON de respuesta contenga los datos del mock
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.comprador_id").value(1L));
    }

}
