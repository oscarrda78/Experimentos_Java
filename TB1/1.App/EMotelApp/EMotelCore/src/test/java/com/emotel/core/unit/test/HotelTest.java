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

import com.emotel.core.entities.Hotel;
import com.emotel.core.service.IHotelService;
import com.emotel.core.unit.suite.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.Silent.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelTest {


	@Mock
	private Hotel hotel;
	
	@Mock
	private IHotelService hotelService;
	
	
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
 public void b_listar() {
 	try {
 		System.out.println("Método Listar");
 		List<Hotel> listaHotel = spy(new ArrayList<Hotel>());
 		when(listaHotel.add(new Hotel())).thenReturn(true);
 		when(hotelService.listar()).thenReturn(listaHotel);
 		List<Hotel> lista = hotelService.listar();
 		Assert.assertTrue(lista.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();		
         Assert.fail();
		}
 }
 

}
//>>>>>>> 2a956fbc6e301c9dfbc150313a9f7cdcf8c238db
