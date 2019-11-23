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

import com.emotel.core.entities.TipoHotel;
import com.emotel.core.service.ITipoHotelService;
import com.emotel.core.service.TipoHotelService;
import com.emotel.core.unit.suite.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@RunWith(MockitoJUnitRunner.Silent.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipoHotelTest {
	
	@Mock
	private TipoHotel tipohotel;
	
	@Mock
	private ITipoHotelService tipohotelService;
	
	@BeforeClass
    public static void inicioClase() {
        System.out.println("Inicio de la clasee");
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
    		when(tipohotel.getId()).thenReturn(1);
    		when(tipohotel.getNombre()).thenReturn("Deluxe");
    		when(tipohotel.getDescripcion()).thenReturn("La más alta gama");
    		when(tipohotelService.agregar(new TipoHotel())).thenReturn(true);
    		tipohotelService.agregar(tipohotel);
    		Assert.assertTrue(tipohotel.getId() > 0);
		} catch (Exception e) {
			e.printStackTrace();
            Assert.fail();
		}
    }
    
    @Test
    public void b_listar() {
    	try {
    		System.out.println("Método Listar");
    		List<TipoHotel> listaTipoHotel = spy(new ArrayList<TipoHotel>());
    		when(listaTipoHotel.add(new TipoHotel())).thenReturn(true);
    		when(listaTipoHotel.add(new TipoHotel())).thenReturn(true);
    		when(tipohotelService.listar()).thenReturn(listaTipoHotel);
    		List<TipoHotel> lista = tipohotelService.listar();
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
    		when(tipohotelService.eliminar(tipohotel.getId())).thenReturn(true);
    		tipohotelService.eliminar(tipohotel.getId());
    		Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
            Assert.fail();
		}
    }
    
    
}
