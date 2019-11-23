package com.emotel.test.system.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.emotel.test.system.selenium.driver.EMotelDriver;



public class InicioPage {
	private By linkLoginAdmin = By.xpath("/html/body/nav/div/div[2]/ul/li[4]");
	private By linkLoginUsuario = By.xpath("/html/body/nav/div/div[2]/ul/li[2]");
	private By linkRegistroUsuario = By.xpath("/html/body/nav/div/div[2]/ul/li[3]");
	private WebDriver webDriver = null;
	
	public InicioPage(String navegador, boolean remoto) {
		this.webDriver = EMotelDriver.inicializarDriver(navegador, remoto);
	}
	
	/*public void ingresarPaginaInicio(String urlInicial) throws Exception{
		webDriver.get(urlInicial);
		Thread.sleep(2000);
	}*/
	
	public void hacerClicLoginAdmin() throws Exception{
		webDriver.findElement(linkLoginAdmin).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicLoginUsuario() throws Exception{
		webDriver.findElement(linkLoginUsuario).click();
		Thread.sleep(2000);
	}
	
	public void hacerClicRegistroUsuario() throws Exception{
		webDriver.findElement(linkRegistroUsuario).click();
		Thread.sleep(2000);
	}
	
	public void cerrarPagina(){
		EMotelDriver.cerrarPagina(webDriver);
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
}
