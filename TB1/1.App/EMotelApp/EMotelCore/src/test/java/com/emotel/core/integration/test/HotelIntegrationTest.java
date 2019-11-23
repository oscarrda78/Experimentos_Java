package com.emotel.core.integration.test;

import static org.mockito.Mockito.doNothing;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emotel.core.entities.Hotel;
import com.emotel.core.entities.TipoHotel;
import com.emotel.core.service.HotelService;
import com.emotel.core.service.IHotelService;
import com.emotel.core.service.ITipoHotelService;
import com.emotel.core.service.TipoHotelService;
import com.jayway.jsonpath.ParseContext;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class HotelIntegrationTest {
	/*
	private final IHotelService hotelService = new HotelService();
	private static Hotel hotel = new Hotel();
	private String nombre = "";
	private String ubicacion = "";
	private double precio;
	private int id;
	
	@Mock
	private HttpServletResponse response;
	
	
	@Given("^el administrador se loggea a la aplicacion \"([^\"]*)\"$")
    public void el_administrador_se_loggea_a_la_aplicacion(String strArg1) throws Throwable {
		MockitoAnnotations.initMocks(this);
		doNothing().when(response).sendRedirect("http://master/EMotelWeb");
		Assert.assertTrue(true);
    }

    @When("^da clic en la seccion \"([^\"]*)\"$")
    public void da_clic_en_la_seccion_hoteles(String strArg1) throws Throwable {
    	doNothing().when(response).sendRedirect("http://master/tipohotel_listar.html");
		Assert.assertTrue(true);
    }

    @Then("^Guarda en la base de datos el nuevo hotel$")
    public void guarda_en_la_base_de_datos_el_nuevo_hotel() throws Throwable {
    	doNothing().when(response).sendRedirect("http://master/hotel_listar.html");
		Assert.assertTrue(true);
    }

    @Then("^se elimina el hotel de la base de datos$")
    public void se_elimina_el_hotel_de_la_base_de_datos() throws Throwable {
    	doNothing().when(response).sendRedirect("http://master/tipohotel_listar.html");
		Assert.assertTrue(true);
    }

    @And("^se redirecciona a la vista del \"([^\"]*)\" en Hoteles$")
    public void se_redirecciona_a_la_vista_del_registro_en_hoteles(String strArg1) throws Throwable {
    	doNothing().when(response).sendRedirect("http://master/hotel_registrar.html");
		Assert.assertTrue(true);
    }

    @And("^en la pantalla escribo en campo Nombre el valor \"([^\"]*)\"$")
    public void en_la_pantalla_escribo_en_campo_nombre_el_valor(String strArg1) throws Throwable {
        nombre = strArg1;
        hotel.setNombre(nombre);
    }

    @And("^en la pantalla escribo en campo Precio el valor \"([^\"]*)\"$")
    public void en_la_pantalla_escribo_en_campo_precio_el_valor(String strArg1) throws Throwable {
    	precio = Double.parseDouble(strArg1);
    	hotel.setPrecio(precio);
    }

    @And("^en la pantalla escribo en campo Ubicacion el valor \"([^\"]*)\"$")
    public void en_la_pantalla_escribo_en_campo_ubicacion_el_valor(String strArg1) throws Throwable {
        ubicacion = strArg1;
        hotel.setUbicacion(ubicacion);
    }

    @And("^da clic en \"([^\"]*)\"$")
    public void da_clic_en_registrar(String strArg1) throws Throwable {
    	try {
			hotelService.agregar(hotel);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Error: " + e.getMessage());
		}
    }

    @And("^da clic al boton \"([^\"]*)\"$")
    public void da_clic_al_boton_eliminar(String strArg1) throws Throwable {
    	try {
			id = hotel.getId();
			hotelService.eliminar(id);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
    }
    */
}
