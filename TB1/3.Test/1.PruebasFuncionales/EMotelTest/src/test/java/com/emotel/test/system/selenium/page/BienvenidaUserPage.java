package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;

public class BienvenidaUserPage {
	private By linkReservaHotel = By.linkText("Reservar hotel");
	private By linkReservaRestaurante = By.linkText("Reservar restaurante");
	private WebDriver webDriver = null;
	
	public BienvenidaUserPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void hacerClicReservaHotel() throws Exception{
		webDriver.findElement(linkReservaHotel).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicReservaRestaurante() throws Exception{
		webDriver.findElement(linkReservaRestaurante).click();
		Thread.sleep(2000);
	}
	
	public void cerrarPagina() {
		EMotelDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
