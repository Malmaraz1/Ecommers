package com.example.ecommerce.Controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.ecommerce.Controller.ControllerProducto;
import com.example.ecommerce.Dto.ProductoDto;
import com.example.ecommerce.Service.ServicioProductoImp;

@WebMvcTest(ControllerProducto.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private ServicioProductoImp servicioProductoImp;

    @Test
    void detalleProducto() throws Exception {

        ProductoDto productoFalso = new ProductoDto();
        productoFalso.setId(1L);
        productoFalso.setNombre("Teclado Mecánico");
        productoFalso.setPrecio(15000.0);

        when(servicioProductoImp.buscarProducto(1L)).thenReturn(Optional.of(productoFalso));

        mvc.perform(MockMvcRequestBuilders.get("/productos/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Teclado Mecánico"))
                .andExpect(jsonPath("$.precio").value(15000.0));

    }

}
