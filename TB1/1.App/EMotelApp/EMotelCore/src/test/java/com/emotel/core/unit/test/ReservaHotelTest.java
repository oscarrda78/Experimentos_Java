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
//import com.emotel.core.entities.ReservaHotel;
//import com.emotel.core.service.IReservaHotelService;
//import com.emotel.core.unit.suite.PruebasUnitariasTest;
//
//@Category(PruebasUnitariasTest.class)
//@RunWith(MockitoJUnitRunner.Silent.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ReservaHotelTest {
//	
//	@Mock
//	private ReservaHotel reservahotel;
//	
//	@Mock
//	private IReservaHotelService reservahotelService;
//	
//}
//=======
package com.emotel.core.unit.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.emotel.core.entities.ReservaHotel;
import com.emotel.core.service.IHotelService;
import com.emotel.core.service.IReservaHotelService;
import com.emotel.core.service.ReservaHotelService;
import com.emotel.core.unit.suite.PruebasUnitariasTest;

@Category(PruebasUnitariasTest.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReservaHotelTest {

	private ReservaHotel reservahotel;
	
	private IReservaHotelService reservahotelService;
	
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
        reservahotel=new ReservaHotel();
        reservahotelService =new ReservaHotelService();
    }

	@After
    public void finMetodo() {
        System.out.println("Fin Metodo");
    }
    
	
	@Test
	public void b_ratioPersonasTest()
	{
		boolean flag=reservahotelService.ratioPersonas(1);
		assertEquals(true, flag);
	}
	@Test
	public void c_ratioPersonasTest()
	{
		boolean flag=reservahotelService.ratioPersonas(-1);
		assertEquals(false, flag);
	}
	@Test
	public void d_ratioPersonasTest()
	{
		boolean flag=reservahotelService.ratioPersonas(4);
		assertEquals(false, flag);
	}
	
	@Test
	public void e_fechaTest() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "22-01-2015 10:20:56";
		Date date;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			date =new Date();
		}
		reservahotel.setFecha(date);
		boolean flag=reservahotelService.fechaCorrecta(reservahotel);
		assertEquals(false, flag);
	}
	@Test
	public void f_fechaTest() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "22-01-2020 10:20:56";
		Date date;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			date =new Date();
		}
		reservahotel.setFecha(date);
		boolean flag=reservahotelService.fechaCorrecta(reservahotel);
		assertEquals(true, flag);
	}
}
//>>>>>>> 2a956fbc6e301c9dfbc150313a9f7cdcf8c238db
