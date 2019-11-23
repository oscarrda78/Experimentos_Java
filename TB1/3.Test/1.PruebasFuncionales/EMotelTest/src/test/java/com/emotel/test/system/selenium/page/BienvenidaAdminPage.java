package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;

public class BienvenidaAdminPage {
	private By linkRegistroTipoHotel = By.linkText("Registrar tipo hotel");
	private By linkRegistroHotel = By.linkText("Registrar hotel");
	private By linkRegistroRestaurante = By.linkText("Registrar restaurante");
	private WebDriver webDriver = null;
	
	public BienvenidaAdminPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void hacerClicRegistroTipoHotel() throws Exception{
		webDriver.findElement(linkRegistroTipoHotel).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicRegistroHotel() throws Exception{
		webDriver.findElement(linkRegistroHotel).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicRegistroRestaurante() throws Exception{
		webDriver.findElement(linkRegistroRestaurante).click();
		Thread.sleep(2000);
	}
	
	public void cerrarPagina() {
		EMotelDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
