//<<<<<<< HEAD
//package com.emotel.core.unit.test;
//
//import org.junit.FixMethodOrder;
//import org.junit.experimental.categories.Category;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.emotel.core.entities.Restaurante;
//import com.emotel.core.service.IRestauranteService;
//import com.emotel.core.unit.suite.PruebasUnitariasTest;
//
//@Category(PruebasUnitariasTest.class)
//@RunWith(MockitoJUnitRunner.Silent.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class RestauranteTest {
//	@Mock
//	private Restaurante restaurante;
//	
//	@Mock
//	private IRestauranteService restauranteService;
//	
//	
//}
//=======
package com.emotel.core.unit.test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.emotel.core.entities.Restaurante;
import com.emotel.core.entities.TipoHotel;
import com.emotel.core.service.IRestauranteService;
import com.emotel.core.unit.suite.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.Silent.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestauranteTest {
	@Mock
	private Restaurante restaurante;
	
	@Mock
	private IRestauranteService restauranteService;
	
	@BeforeClass
	    public static void inicioClase() {
	        System.out.println("Inicio de la clase");
	    }

	@AfterClass
	    public static void finClase() {
	        System.out.println("Fin de la clase");
	    }

	@Before
	    public void inicioMetodo() {
	        System.out.println("Inicio Metodo");
	    }

	 @After
	    public void finMetodo() {
	        System.out.println("Fin Metodo");
	    }
	    
	 @Test
	    public void a_insertar() {
	      try {
	        System.out.println("Método Insertar");
	        when(restaurante.getId()).thenReturn(1);
	        when(restaurante.getNombre()).thenReturn("Deluxe");
	        when(restaurante.getPrecio()).thenReturn(15.2);
	        when(restaurante.getDescripcion()).thenReturn("Restaurante 5 estrellas");
	        when(restaurante.getUbicacion()).thenReturn("Centro de Lima");
	        when(restauranteService.agregar(new Restaurante())).thenReturn(true);
	        restauranteService.agregar(restaurante);
	        Assert.assertTrue(restaurante.getId() > 0);
	    } catch (Exception e) {
	      e.printStackTrace();
	            Assert.fail();
	    }
	    }
	 
	 @Test
	    public void b_listar() {
	    	try {
	    		System.out.println("Método Listar");
	    		List<Restaurante> listarestaurante = spy(new ArrayList<Restaurante>());
	    		when(listarestaurante.add(new Restaurante())).thenReturn(true);
	    		when(listarestaurante.add(new Restaurante())).thenReturn(true);
	    		when(restauranteService.listar()).thenReturn(listarestaurante);
	    		List<Restaurante> lista = restauranteService.listar();
	    		Assert.assertTrue(lista.size() > 0);
			} catch (Exception e) {
				e.printStackTrace();
				
				
	            Assert.fail();
			}
	    }
	    
	    @Test
	    public void c_eliminar() {
	    	try {
	    		System.out.println("Método Eliminar");
	    		when(restauranteService.eliminar(restaurante.getId())).thenReturn(true);
	    		restauranteService.eliminar(restaurante.getId());
	    		Assert.assertTrue(true);
			} catch (Exception e) {
				e.printStackTrace();
	            Assert.fail();
			}
	    }
	    
}
//>>>>>>> 2a956fbc6e301c9dfbc150313a9f7cdcf8c238db
