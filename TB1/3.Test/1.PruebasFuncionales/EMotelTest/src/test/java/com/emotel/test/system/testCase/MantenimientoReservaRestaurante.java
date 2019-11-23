package com.emotel.test.system.testCase;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.emotel.test.system.selenium.dataManager.Excel;
import com.emotel.test.system.selenium.page.BienvenidaUserPage;
import com.emotel.test.system.selenium.page.LoginUserPage;
import com.emotel.test.system.selenium.page.ReservaRestaurantePage;
import com.emotel.test.system.selenium.util.Utilitario;
import com.emotel.test.system.testlink.util.EMotelTestlink;

public class MantenimientoReservaRestaurante {
	private LoginUserPage loginUserPage;
	private BienvenidaUserPage bienvenidaUserPage;
	private ReservaRestaurantePage reservaRestaurantePage;
	private String rutaCarpetaError = "C:\\CapturasPantallas\\EMotel\\ReservaRestaurante";
	private Integer idNavegadorTestlink;
	private String nombreNavegadorTestlink;
	
	@BeforeTest
	@Parameters({ "navegador", "remoto", "testlinkNavegadorId", "testlinkNavegadorNombre" })
	public void inicioClase(String navegador, int remoto, 
			int testlinkNavegadorId, String testlinkNavegadorNombre) throws Exception {
		this.loginUserPage = new LoginUserPage(navegador.toLowerCase(), remoto == 1);
		this.bienvenidaUserPage = new BienvenidaUserPage(this.loginUserPage.getWebDriver());
		this.reservaRestaurantePage = new ReservaRestaurantePage(this.loginUserPage.getWebDriver());
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
	public void reservarRestaurante(String casoPrueba, String urlInicial, String correo, String password,
			String fecha, String hora, String personas, String valorEsperado, String urlTestlink, 
			String keyTestlink, String idTestCaseInterno, String idTestCaseExterno, String idTestPlan, 
			String idBuild, String nombreBuild) throws Exception{
		try {
			this.loginUserPage.ingresarPaginaInicio(urlInicial);
			this.loginUserPage.iniciarSesion(correo, password);
			this.bienvenidaUserPage.hacerClicReservaRestaurante();
			this.reservaRestaurantePage.escribirCampoFecha(fecha.trim());
			this.reservaRestaurantePage.escribirCampoHora(hora.trim());
			this.reservaRestaurantePage.escribirCampoPersonas(personas.trim());
			String valorObtenido = reservaRestaurantePage.hacerClicBotonRegistrar();
			Assert.assertEquals(valorObtenido, valorEsperado);
		} catch (AssertionError e) {
			Utilitario.caputarPantallarError(rutaCarpetaError, e.getMessage(), reservaRestaurantePage.getWebDriver());
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
		reservaRestaurantePage.cerrarPagina();
	}
}
