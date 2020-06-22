package com.tatcs.testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tatcs.frameworkPackage.BrowserFactory;

public class LoadTest02{

	private WebDriver driver;
	public LoadTest02(){
	}
	
	@BeforeClass
	public void beforeClass() {
		new BrowserFactory();
		driver = BrowserFactory.getDriver("ie");
	}
	@Test
	public void returnTicket() {
		try {
			// TODO
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
