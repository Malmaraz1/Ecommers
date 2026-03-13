import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Factura;

import com.example.ecommerce.Model.Pedido;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Model.Usuario;

public class TestCarrito {

        @Test
        void AgregarItemCarrito() {
                // 1. Creamos la categoría una sola vez
                Categoria categoriaTest = new Categoria(
                                "Electrodomésticos", // nombre
                                "electrodomesticos", // slug
                                "Aparatos para el hogar", // descripcion
                                1 // nivel
                );
                categoriaTest.setId(1L);

                Producto productoTest1 = new Producto();
                productoTest1.setId(100L); // ID Único
                productoTest1.setNombre("Lavarropas Drean Next 8.14");
                productoTest1.setPrecio(150000);
                productoTest1.setCategoria(categoriaTest);
                productoTest1.setModelo("Next 8.14 WCR");
                productoTest1.setMarca("Dream");
                productoTest1.setFechaCreacion(LocalDate.now());
                productoTest1.setDescripcion_productro("descripcion de prueba 1");

                Producto productoTest2 = new Producto();
                productoTest2.setId(101L); // ID Único
                productoTest2.setNombre("Heladera Gafa"); // Nombre distinto para diferenciar
                productoTest2.setPrecio(150000);
                productoTest2.setCategoria(categoriaTest);
                productoTest2.setModelo("HGF387W");
                productoTest2.setMarca("Gafa");
                productoTest2.setFechaCreacion(LocalDate.now());
                productoTest2.setDescripcion_productro("descripcion de prueba 2");

                Producto productoTest3 = new Producto();
                productoTest3.setId(102L); // ID Único
                productoTest3.setNombre("Microondas BGH");
                productoTest3.setPrecio(150000);
                productoTest3.setCategoria(categoriaTest);
                productoTest3.setModelo("Quick Chef");
                productoTest3.setMarca("BGH");
                productoTest3.setFechaCreacion(LocalDate.now());
                productoTest3.setDescripcion_productro("descripcion de prueba 3");

                Usuario usuario = new Usuario();
                usuario.setNombre("usuario1");
                usuario.setId(1L);

                Carrito carrito = new Carrito(usuario);

                carrito.agregarItem(productoTest1, 2);
                carrito.agregarItem(productoTest2, 2);
                carrito.agregarItem(productoTest3, 2);

                assertEquals(3, carrito.getItemsCarrito().size(), "El carrito debería tener 3 ítems distintos");
                assertEquals(900000, carrito.getItemsCarrito().stream().mapToInt(i -> i.calcularTotal()).sum(),
                                "El total de la compra debería ser 900.000");
        }

        @Test
        void generarPedido() {
                Categoria categoriaTest = new Categoria(
                                "Electrodomésticos", // nombre
                                "electrodomesticos", // slug
                                "Aparatos para el hogar", // descripcion
                                1 // nivel
                );
                categoriaTest.setId(1L);

                Producto productoTest1 = new Producto();
                productoTest1.setId(100L); // ID Único
                productoTest1.setNombre("Lavarropas Drean Next 8.14");
                productoTest1.setPrecio(150000);
                productoTest1.setCategoria(categoriaTest);
                productoTest1.setModelo("Next 8.14 WCR");
                productoTest1.setMarca("Dream");
                productoTest1.setFechaCreacion(LocalDate.now());
                productoTest1.setDescripcion_productro("descripcion de prueba 1");

                Producto productoTest2 = new Producto();
                productoTest2.setId(101L); // ID Único
                productoTest2.setNombre("Heladera Gafa"); // Nombre distinto para diferenciar
                productoTest2.setPrecio(150000);
                productoTest2.setCategoria(categoriaTest);
                productoTest2.setModelo("HGF387W");
                productoTest2.setMarca("Gafa");
                productoTest2.setFechaCreacion(LocalDate.now());
                productoTest2.setDescripcion_productro("descripcion de prueba 2");

                Producto productoTest3 = new Producto();
                productoTest3.setId(102L); // ID Único
                productoTest3.setNombre("Microondas BGH");
                productoTest3.setPrecio(150000);
                productoTest3.setCategoria(categoriaTest);
                productoTest3.setModelo("Quick Chef");
                productoTest3.setMarca("BGH");
                productoTest3.setFechaCreacion(LocalDate.now());
                productoTest3.setDescripcion_productro("descripcion de prueba 3");

                Usuario usuario = new Usuario();
                usuario.setNombre("usuario1");
                usuario.setId(1L);

                Carrito carrito = new Carrito(usuario);

                carrito.agregarItem(productoTest1, 2);
                carrito.agregarItem(productoTest2, 2);
                carrito.agregarItem(productoTest3, 2);

                Pedido pedido = new Pedido();
                pedido.setComprador(usuario);
                pedido.setId(1L);
                pedido.setItems_carrito(carrito.getItemsCarrito());

                assertEquals(3, pedido.getItems_carrito().size(), "El pedido debería tener 3 ítems distintos");
                assertEquals(900000, pedido.getItems_carrito().stream().mapToInt(i -> i.calcularTotal()).sum(),
                                "El total de la compra debería ser 900.000");

        }

   @Test
    void GenerarFactura(){
          Categoria categoriaTest = new Categoria(
                "Electrodomésticos", // nombre
                "electrodomesticos", // slug
                "Aparatos para el hogar", // descripcion
                1 // nivel
        );
        categoriaTest.setId(1L);

        Producto productoTest1 = new Producto();
        productoTest1.setId(100L); // ID Único
        productoTest1.setNombre("Lavarropas Drean Next 8.14");
        productoTest1.setPrecio(150000);
        productoTest1.setCategoria(categoriaTest);
        productoTest1.setModelo("Next 8.14 WCR");
        productoTest1.setMarca("Dream");
        productoTest1.setFechaCreacion(LocalDate.now());
        productoTest1.setDescripcion_productro("descripcion de prueba 1");

        Producto productoTest2 = new Producto();
        productoTest2.setId(101L); // ID Único
        productoTest2.setNombre("Heladera Gafa"); // Nombre distinto para diferenciar
        productoTest2.setPrecio(150000);
        productoTest2.setCategoria(categoriaTest);
        productoTest2.setModelo("HGF387W");
        productoTest2.setMarca("Gafa");
        productoTest2.setFechaCreacion(LocalDate.now());
        productoTest2.setDescripcion_productro("descripcion de prueba 2");

        Producto productoTest3 = new Producto();
        productoTest3.setId(102L); // ID Único
        productoTest3.setNombre("Microondas BGH");
        productoTest3.setPrecio(150000);
        productoTest3.setCategoria(categoriaTest);
        productoTest3.setModelo("Quick Chef");
        productoTest3.setMarca("BGH");
        productoTest3.setFechaCreacion(LocalDate.now());
        productoTest3.setDescripcion_productro("descripcion de prueba 3");

        Usuario usuario = new Usuario();
        usuario.setNombre("usuario1");
        usuario.setId(1L);

        Carrito carrito = new Carrito(usuario);

        carrito.agregarItem(productoTest1, 2);
        carrito.agregarItem(productoTest2, 2);
        carrito.agregarItem(productoTest3, 2);

        Pedido pedido = new Pedido();
        pedido.setComprador(usuario);
        pedido.setId(1L);
        pedido.setItems_carrito(carrito.getItemsCarrito());

       
        


        Factura factura = new Factura(pedido);


        assertEquals(factura.getComprador(), pedido.getComprador());
        assertTrue(factura.getItemFactura().size() == 3);
        assertEquals( 900000,factura.getTotal_factura());
        

        
        
        
    }
}