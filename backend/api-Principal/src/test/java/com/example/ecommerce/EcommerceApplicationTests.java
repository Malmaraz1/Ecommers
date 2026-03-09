package com.example.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce.Dto.ProductoDto;
import com.example.ecommerce.Dto.StockDto;
import com.example.ecommerce.Dto.Request.ProductoRequestDto;
import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Repository.RepositorioCategoria;
import com.example.ecommerce.Repository.RepositorioProducto;
import com.example.ecommerce.Service.ServicioProductoImp;
import com.example.ecommerce.Service.ServiceImp.ServicioProducto;
import com.example.ecommerce.clients.StockClientRest;

@ExtendWith(MockitoExtension.class)
class EcommerceApplicationTests {

	// 2. Usamos @Mock para que Mockito cree los repositorios falsos automáticamente
	@Mock
	RepositorioProducto repositorioProducto;

	@Mock
	RepositorioCategoria repositorioCategoria;

	@Mock
	StockClientRest stockClientRest;
	// 3. Usamos @InjectMocks para que Mockito meta los mocks dentro de tu servicio
	@InjectMocks
	ServicioProductoImp servicioProductoImp;

	@Test
	void guardarProducto() {

		Categoria categoriaTest = new Categoria(
				"Electrodomésticos", // nombre
				"electrodomesticos", // slug
				"Aparatos para el hogar", // descripcion
				1 // nivel
		);
		categoriaTest.setId(1L);
		Producto productoTest = new Producto();
		productoTest.setId(100L);
		productoTest.setNombre("Lavarropas Drean Next 8.14");
		productoTest.setPrecio(150000.00);
		productoTest.setCategoria(categoriaTest); // <-- Acá le inyectamos la categoría que creamos arriba
		productoTest.setModelo("Next 8.14 WCR");
		productoTest.setMarca("Dream");
		productoTest.setFechaCreacion(LocalDate.now());
		productoTest.setDescripcion_productro("descripcion de prueba");
		productoTest.setImagen(null);
		ProductoRequestDto productoRequestDto = new ProductoRequestDto();
		productoRequestDto.mapearProducto(productoTest);
		StockDto stockDtoTest = new StockDto();
		stockDtoTest.setProducto_id(productoTest.getId());
		stockDtoTest.setDeposito_id((long) 1);

		when(repositorioCategoria.findById(any())).thenReturn(Optional.of(categoriaTest));
		when(repositorioProducto.save(any(Producto.class))).thenReturn(productoTest);
		when(stockClientRest.crear(any(StockDto.class))).thenReturn(stockDtoTest);

		servicioProductoImp.guardarProducto(productoRequestDto);

		verify(repositorioProducto).save(any(Producto.class));
		verify(repositorioCategoria).findById(1L);
		verify(stockClientRest).crear(any(StockDto.class));

	}

	@Test
	void EliminarProducto() {

		Categoria categoriaTest = new Categoria(
				"Electrodomésticos", // nombre
				"electrodomesticos", // slug
				"Aparatos para el hogar", // descripcion
				1 // nivel
		);
		categoriaTest.setId(1L);
		Producto productoTest = new Producto();
		productoTest.setId(100L);
		productoTest.setNombre("Lavarropas Drean Next 8.14");
		productoTest.setPrecio(150000.00);
		productoTest.setCategoria(categoriaTest); // <-- Acá le inyectamos la categoría que creamos arriba
		productoTest.setModelo("Next 8.14 WCR");
		productoTest.setMarca("Dream");
		productoTest.setFechaCreacion(LocalDate.now());
		productoTest.setDescripcion_productro("descripcion de prueba");
		productoTest.setImagen(null);
		ProductoRequestDto productoRequestDto = new ProductoRequestDto();
		productoRequestDto.mapearProducto(productoTest);
		

		when(repositorioProducto.findById(any())).thenReturn(Optional.of(productoTest));

		servicioProductoImp.eliminarProducto(productoTest.getId());

		verify(repositorioProducto).findById(productoTest.getId());
		verify(repositorioProducto).delete(productoTest);

	}

	@Test
	void editarProducto() {

		Categoria categoriaTest = new Categoria(
				"Electrodomésticos", // nombre
				"electrodomesticos", // slug
				"Aparatos para el hogar", // descripcion
				1 // nivel
		);
		categoriaTest.setId(1L);
		Producto productoTest = new Producto();
		productoTest.setId(100L);
		productoTest.setNombre("Lavarropas Drean Next 8.14");
		productoTest.setPrecio(150000.00);
		productoTest.setCategoria(categoriaTest); // <-- Acá le inyectamos la categoría que creamos arriba
		productoTest.setModelo("Next 8.14 WCR");
		productoTest.setMarca("Dream");
		productoTest.setFechaCreacion(LocalDate.now());
		productoTest.setDescripcion_productro("descripcion de prueba");
		productoTest.setImagen(null);
	

		Categoria categoriaTest2 = new Categoria(
				"Electrodomésticos", // nombre
				"electrodomesticos", // slug
				"Aparatos para el hogar", // descripcion
				1 // nivel
		);
		categoriaTest2.setId(1L);


		Producto productoTest2 = new Producto();
		productoTest2.setNombre("Lavarropas");
		productoTest2.setMarca("Nueva Marca");
		productoTest2.setCategoria(categoriaTest2);
	
		ProductoRequestDto productoRequestDto2 = new ProductoRequestDto();
		productoRequestDto2.mapearProducto(productoTest2);
		

		when(repositorioProducto.findById(any())).thenReturn(Optional.of(productoTest));
		when(repositorioProducto.save(any(Producto.class))).thenReturn(productoTest);
	    when(repositorioCategoria.getReferenceById(productoTest.getCategoria().getId())).thenReturn(categoriaTest);
         
		servicioProductoImp.editarProducto(productoTest.getId(),productoRequestDto2);
        
		verify(repositorioProducto).save(any(Producto.class));
		assertEquals("Lavarropas", productoTest.getNombre(), "El nombre del producto es " + productoTest.getNombre() + " ");
		assertEquals("Nueva Marca",productoTest.getMarca() , "El marca del producto es " + productoTest.getMarca() + " ");

	}

	



}
