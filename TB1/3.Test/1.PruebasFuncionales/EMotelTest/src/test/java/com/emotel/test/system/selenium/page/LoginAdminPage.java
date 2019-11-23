package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;

public class LoginAdminPage {
	private By cajaCorreo = By.id("txtCorreo");
	private By cajaPassword = By.id("txtPassword");
	private By botonIngresar = By.id("btnIngresar");
	private WebDriver webDriver = null;
	
	/*public LoginAdminPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}*/
	
	public LoginAdminPage(String navegador, boolean remoto) {
		this.webDriver = EMotelDriver.inicializarDriver(navegador, remoto);
	}
	
	public void ingresarPaginaInicio(String urlInicial) throws Exception{
		webDriver.get(urlInicial);
		Thread.sleep(2000);
	}
	
	public void iniciarSesion(String correo, String password) throws Exception{
		webDriver.findElement(cajaCorreo).clear();
		webDriver.findElement(cajaCorreo).sendKeys(correo);
		webDriver.findElement(cajaPassword).clear();
		webDriver.findElement(cajaPassword).sendKeys(password);
		webDriver.findElement(botonIngresar).click();
		Thread.sleep(2000);
	}
	
	public void cerrarPagina(){
		EMotelDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
