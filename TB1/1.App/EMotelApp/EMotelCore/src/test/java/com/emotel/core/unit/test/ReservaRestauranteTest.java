//<<<<<<< HEAD
//package com.emotel.core.unit.test;
//
//import org.junit.FixMethodOrder;
//import org.junit.experimental.categories.Category;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.emotel.core.entities.ReservaRestaurante;
//import com.emotel.core.service.IReservaRestauranteService;
//import com.emotel.core.unit.suite.PruebasUnitariasTest;
//
//@Category(PruebasUnitariasTest.class)
//@RunWith(MockitoJUnitRunner.Silent.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ReservaRestauranteTest {
//
//	private ReservaRestaurante reservarestaurante;
//	
//	private IReservaRestauranteService reservarestauranteService;
//}
//=======
package com.emotel.core.unit.test;

import static org.junit.Assert.assertEquals;
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

import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.entities.ReservaRestaurante;
import com.emotel.core.entities.TipoHotel;
import com.emotel.core.service.IReservaRestauranteService;
import com.emotel.core.service.ReservaRestauranteService;
import com.emotel.core.unit.suite.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReservaRestauranteTest {

	private ReservaRestaurante reservarestaurante;
	private IReservaRestauranteService reservarestauranteService;
	
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
        reservarestaurante= new ReservaRestaurante();
        reservarestauranteService = new ReservaRestauranteService();
        
    }

	@After
    public void finMetodo() {
        System.out.println("Fin Metodo");
    }
	
	@Test
	public void a_mismoPaisReserva()
	{
		ReservaHotel reservaHotel=new ReservaHotel();
		reservarestaurante.setPais("Peru");
		
		boolean flag= reservarestauranteService.mismoPaisReserva(reservaHotel, reservarestaurante);
		assertEquals(true, flag);
	}
	@Test
	public void b_mismoPaisReserva()
	{
		ReservaHotel reservaHotel=new ReservaHotel();
		reservarestaurante.setPais("Chile");
		
		boolean flag= reservarestauranteService.mismoPaisReserva(reservaHotel, reservarestaurante);
		assertEquals(false, flag);
	}
	    
    
}
//>>>>>>> 2a956fbc6e301c9dfbc150313a9f7cdcf8c238db
