package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;

public class RegistroTipoHotelPage {
	private By cajaNombre = By.id("txtNombre");
	private By cajaDescripcion = By.id("txtDescripcion");
	private By botonRegistrar = By.id("btnRegistrar");
	private By mensajeRespuesta = By.id("msgMensaje");
	private WebDriver webDriver = null;
	
	public RegistroTipoHotelPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	
	public void escribirCampoNombre(String nombre) throws Exception {
		webDriver.findElement(cajaNombre).clear();
		webDriver.findElement(cajaNombre).sendKeys(nombre);
		Thread.sleep(2000);
	}
	
	public void escribirCampoDescripcion(String descripcion) throws Exception {
		webDriver.findElement(cajaDescripcion).clear();
		webDriver.findElement(cajaDescripcion).sendKeys(descripcion);
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
