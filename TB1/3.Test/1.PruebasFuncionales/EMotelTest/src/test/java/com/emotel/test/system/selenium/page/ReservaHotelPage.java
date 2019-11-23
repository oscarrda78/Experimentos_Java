package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;

public class ReservaHotelPage {
	private By cajaFecha = By.id("txtFecha");
	private By cajaDias = By.id("txtDias");
	private By cajaCuartos = By.id("txtCuartos");
	private By cajaPersonas = By.id("txtPersonas");
	private By botonRegistrar = By.id("btnRegistrar");
	private By mensajeRespuesta = By.id("msgMensaje");
	private WebDriver webDriver = null;
	
	public ReservaHotelPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void escribirCampoFecha(String fecha) throws Exception {
		webDriver.findElement(cajaFecha).sendKeys(fecha);
		Thread.sleep(2000);
	}
	
	public void escribirCampoDias(String dias) throws Exception {
		webDriver.findElement(cajaDias).clear();
		webDriver.findElement(cajaDias).sendKeys(dias);
		Thread.sleep(2000);
	}
	
	public void escribirCampoCuartos(String cuartos) throws Exception {
		webDriver.findElement(cajaCuartos).clear();
		webDriver.findElement(cajaCuartos).sendKeys(cuartos);
		Thread.sleep(2000);
	}
	
	public void escribirCampoPersonas(String personas) throws Exception {
		webDriver.findElement(cajaPersonas).clear();
		webDriver.findElement(cajaPersonas).sendKeys(personas);
		Thread.sleep(2000);
	}
	
	public String hacerClicBotonRegistrar() throws Exception{
		webDriver.findElement(botonRegistrar).click();
		Thread.sleep(2000);
		return webDriver.findElement(mensajeRespuesta).getText();
	}
	
	public void cerrarPagina(){
		EMotelDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
