package com.example.ecommerce.Service;

import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Repository.RepositorioProducto;
@Service
public class ServicioQuitarItemCarrito extends TemplateAltaBajaCarrito {

    public ServicioQuitarItemCarrito(RepositorioCarrito repositorioCarrito, RepositorioProducto repositorioProducto) {
        super(repositorioCarrito, repositorioProducto);
        
    }

    @Override
    protected void aplicarLogicaDelItem(Carrito carrito, Producto producto, Integer cantidad) {
         carrito.quitarItem(producto, cantidad);
    }
    
}
