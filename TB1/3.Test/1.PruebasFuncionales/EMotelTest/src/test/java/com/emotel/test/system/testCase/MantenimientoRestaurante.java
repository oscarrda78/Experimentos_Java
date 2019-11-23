package com.emotel.test.system.testCase;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.emotel.test.system.selenium.dataManager.Excel;
import com.emotel.test.system.selenium.page.BienvenidaAdminPage;
import com.emotel.test.system.selenium.page.LoginAdminPage;

import com.emotel.test.system.selenium.page.RegistroRestaurantePage;
import com.emotel.test.system.selenium.util.Utilitario;
import com.emotel.test.system.testlink.util.EMotelTestlink;

public class MantenimientoRestaurante {
	private LoginAdminPage loginAdminPage;
	private BienvenidaAdminPage bienvenidaAdminPage;
	private RegistroRestaurantePage registroRestaurantePage;
	private String rutaCarpetaError = "C:\\CapturasPantallas\\EMotel\\Restaurante";
	private Integer idNavegadorTestlink;
	private String nombreNavegadorTestlink;
	
	@BeforeTest
	@Parameters({ "navegador", "remoto", "testlinkNavegadorId", "testlinkNavegadorNombre" })
	public void inicioClase(String navegador, int remoto, 
			int testlinkNavegadorId, String testlinkNavegadorNombre) throws Exception {
		this.loginAdminPage = new LoginAdminPage(navegador.toLowerCase(), remoto == 1);
		this.bienvenidaAdminPage = new BienvenidaAdminPage(this.loginAdminPage.getWebDriver());
		this.registroRestaurantePage = new RegistroRestaurantePage(this.loginAdminPage.getWebDriver());
		this.idNavegadorTestlink = testlinkNavegadorId;
		this.nombreNavegadorTestlink = testlinkNavegadorNombre;
	}
	
	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados(ITestContext context) {
		Object[][] datos = null;
		String fuenteDatos = context.getCurrentXmlTest().getParameter("fuenteDatos");
		System.out.println("Fuente de Datos: " + fuenteDatos);
		switch (fuenteDatos.toLowerCase()) {
		case "excel":
			String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaArchivo");
			datos = Excel.leerExcel(rutaArchivo);
			break;
		}
		return datos;
	}
	
	@Test(dataProvider = "datosEntrada")
	public void registrarRestaurante(String casoPrueba, String urlInicial, String correo, String password,
			String nombre, String precio, String ubicacion, String descripcion, String valorEsperado, 
			String urlTestlink, String keyTestlink, String idTestCaseInterno, String idTestCaseExterno, 
			String idTestPlan, 	String idBuild, String nombreBuild) throws Exception{
		try {
			this.loginAdminPage.ingresarPaginaInicio(urlInicial);
			this.loginAdminPage.iniciarSesion(correo, password);
			this.bienvenidaAdminPage.hacerClicRegistroRestaurante();
			this.registroRestaurantePage.escribirCampoNombre(nombre.trim());
			this.registroRestaurantePage.escribirCampoPrecio(precio.trim());
			this.registroRestaurantePage.escribirCampoDescripcion(descripcion.trim());
			this.registroRestaurantePage.escribirCampoUbicacion(ubicacion.trim());
			String valorObtenido = registroRestaurantePage.hacerClicBotonRegistrar();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (AssertionError e) {
			Utilitario.caputarPantallarError(rutaCarpetaError, e.getMessage(), registroRestaurantePage.getWebDriver());
			EMotelTestlink.reportarCasoDePrueba(urlTestlink, keyTestlink, Integer.parseInt(idTestCaseInterno),
					Integer.parseInt(idTestCaseExterno), Integer.parseInt(idTestPlan), false, Integer.parseInt(idBuild),
					nombreBuild, "Ocurrio un error: " + e.getMessage(), this.idNavegadorTestlink,
					this.nombreNavegadorTestlink);
			Assert.fail(e.getMessage());
		}	catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		registroRestaurantePage.cerrarPagina();
	}
}
