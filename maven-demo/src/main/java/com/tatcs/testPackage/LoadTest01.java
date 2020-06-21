package com.tatcs.testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tatcs.frameworkPackage.BrowserFactory;

public class LoadTest01 {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		new BrowserFactory();
		driver = BrowserFactory.getDriver("ie");
	}

	@Test
	public void verifySearchButton() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		String search_text = "Google Search";
		WebElement search_button = driver.findElement(By.name("btnK"));
		String text = search_button.getAttribute("value");
		Assert.assertEquals(text, search_text, "Google Search Text not found!");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
