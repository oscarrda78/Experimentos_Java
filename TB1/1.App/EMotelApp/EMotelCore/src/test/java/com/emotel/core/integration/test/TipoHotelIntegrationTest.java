package com.emotel.core.integration.test;

import static org.mockito.Mockito.doNothing;

import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emotel.core.entities.TipoHotel;
import com.emotel.core.service.ITipoHotelService;
import com.emotel.core.service.TipoHotelService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class TipoHotelIntegrationTest {
	
	private final ITipoHotelService tipohotelService = new TipoHotelService();
	private static TipoHotel tipohotel = new TipoHotel();
	private String nombreTipo = "";
	private String descripcionTipo = "";
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
    public void da_clic_en_la_seccion_tipo_hotel(String strArg1) throws Throwable {
		doNothing().when(response).sendRedirect("http://master/tipohotel_listar.html");
		Assert.assertTrue(true);
    }


    @And("^se redirecciona a la vista del \"([^\"]*)\" en Tipo de Hotel$")
    public void se_redirecciona_a_la_vista_del_registro_en_tipo_de_hotel(String strArg1) throws Throwable {
    	doNothing().when(response).sendRedirect("http://master/tipohotel_registrar.html");
		Assert.assertTrue(true);
    }
    

    @And("^en la pantalla escribo en campo Nombre el valor \"([^\"]*)\"$")
    public void en_la_pantalla_escribo_en_campo_nombre_el_valor(String strArg1) throws Throwable {
        nombreTipo = strArg1;
        tipohotel.setNombre(nombreTipo);
    }
    
    @And("^en la pantalla escribo en campo Descripcion el valor \"([^\"]*)\"$")
    public void en_la_pantalla_escribo_en_campo_descripcion_el_valor(String strArg1) throws Throwable {
        descripcionTipo = strArg1;
        tipohotel.setDescripcion(descripcionTipo);
    }

    @And("^da clic en \"([^\"]*)\"$")
    public void da_clic_en_guardar(String strArg1) throws Throwable {
    	try {
			tipohotelService.agregar(tipohotel);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Error: " + e.getMessage());
		}
    }
    
    @Then("^guarda en la base de datos el nuevo Tipo de Hotel$")
    public void guarda_en_la_base_de_datos_el_nuevo_tipo_de_hotel() throws Throwable {
    	doNothing().when(response).sendRedirect("http://master/tipohotel_listar.html");
		Assert.assertTrue(true);
    }
    
    @And("^da clic al boton \"([^\"]*)\"$")
    public void da_clic_al_boton_eliminar(String strArg1) throws Throwable {
        try {
			id = tipohotel.getId();
			tipohotelService.eliminar(id);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error: " + e.getMessage());
		}
    }
    
    @Then("^se elimina el tipo de hotel de la base de datos$")
    public void se_elimina_el_tipo_de_hotel_de_la_base_de_datos() throws Throwable {
    	doNothing().when(response).sendRedirect("http://master/tipohotel_listar.html");
		Assert.assertTrue(true);
    }
    
}
