package com.example.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Service.ServiceImp.ServicioPedido;

@Service
public class ServicioPedidoImp implements ServicioPedido {

    @Autowired
    RepositorioCarrito repositorioCarrito;

    @Override
    public Pedido generarPedido(Long carritoId) {

        Carrito carrito = repositorioCarrito.findById(carritoId).orElseThrow();

        return new Pedido(carrito);

    }

}
