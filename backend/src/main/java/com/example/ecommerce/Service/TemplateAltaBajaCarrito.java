package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Repository.RepositorioCarrito;
import com.example.ecommerce.Repository.RepositorioProducto;
import com.example.ecommerce.exceptions.NotFoundException;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TemplateAltaBajaCarrito {
        private final RepositorioCarrito repositorioCarrito;
        private final RepositorioProducto repositorioProducto;

        public final Carrito ejecutar(Long idCarrito, Long idProducto, Integer cantidad) {

                Carrito carrito = repositorioCarrito.findById(idCarrito).orElseThrow(
                                () -> new NotFoundException("no se encontro el carrito"));

                Producto producto = repositorioProducto.findById(idProducto).orElseThrow(
                                () -> new NotFoundException("no se encontro el producto"));

                aplicarLogicaDelItem(carrito, producto, cantidad);

                return repositorioCarrito.save(carrito);
        }

        protected abstract void aplicarLogicaDelItem(Carrito carrito, Producto producto, Integer cantidad);
}
