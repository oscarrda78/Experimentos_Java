package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;

public class ReservaRestaurantePage {
	private By cajaFecha = By.id("txtFecha");
	private By cajaHora = By.id("txtHora");
	private By cajaPersonas = By.id("txtPersonas");
	private By botonRegistrar = By.id("btnRegistrar");
	private By mensajeRespuesta = By.id("msgMensaje");
	private WebDriver webDriver = null;
	
	public ReservaRestaurantePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void escribirCampoFecha(String fecha) throws Exception {
		webDriver.findElement(cajaFecha).sendKeys(fecha);
		Thread.sleep(2000);
	}
	
	public void escribirCampoHora(String hora) throws Exception {
		webDriver.findElement(cajaHora).clear();
		webDriver.findElement(cajaHora).sendKeys(hora);
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
