package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;

public class RegistroRestaurantePage {
	private By cajaNombre = By.id("txtNombre");
	private By cajaPrecio = By.id("txtPrecio");
	private By cajaDescripcion = By.id("txtDescripcion");
	private By cajaUbicacion = By.id("txtUbicacion");
	private By botonRegistrar = By.id("btnRegistrar");
	private By mensajeRespuesta = By.id("msgMensaje");
	private WebDriver webDriver = null;
	
	public RegistroRestaurantePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	
	public void escribirCampoNombre(String nombre) throws Exception {
		webDriver.findElement(cajaNombre).clear();
		webDriver.findElement(cajaNombre).sendKeys(nombre);
		Thread.sleep(2000);
	}
	
	public void escribirCampoPrecio(String precio) throws Exception {
		webDriver.findElement(cajaPrecio).clear();
		webDriver.findElement(cajaPrecio).sendKeys(precio);
		Thread.sleep(2000);
	}
	
	public void escribirCampoDescripcion(String descripcion) throws Exception {
		webDriver.findElement(cajaDescripcion).clear();
		webDriver.findElement(cajaDescripcion).sendKeys(descripcion);
		Thread.sleep(2000);
	}
	
	public void escribirCampoUbicacion(String ubicacion) throws Exception {
		webDriver.findElement(cajaUbicacion).clear();
		webDriver.findElement(cajaUbicacion).sendKeys(ubicacion);
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
