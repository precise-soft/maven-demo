package com.tatcs.uiPackage;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tatcs.frameworkPackage.HighLightElement;


public class TTHomePage {

	WebDriver driver = null;
	HighLightElement hle;

	@FindBy(how=How.ID,using="comp-j6f8gzeaimgimage")
	@CacheLookup
	WebElement primaryLogo;

	@FindBy(how=How.ID,using="comp-j6mauw7bimgimage")
	@CacheLookup
	WebElement secondaryLogo;	

	public TTHomePage(WebDriver driver){
		this.driver=driver;
	}

	static TTHomePage init(WebDriver webDriver) {
		return new TTHomePage(webDriver);
	}

	public boolean isPrimaryLogoExisted() {
		return primaryLogo.isDisplayed();
	}

	public boolean isSecondaryLogoExisted() {
		return secondaryLogo.isDisplayed();
	}

	public boolean isTextExisted(String targetText) {
		boolean existed = false;
		String xpath= "//*[contains(text(),'" + targetText + "')]";

		try {
			Thread.sleep(1000);
			WebElement target = driver.findElement(By.xpath(xpath));
			hle = new HighLightElement(driver, target);
			existed = target.isEnabled();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existed;
	}

	@SuppressWarnings("null")
	public List<String> getMenuItems(){

		List<String> menuItemNameList = new ArrayList<String>();
		for(int index=0; index < 6; index++) {
			String xpathExpression = "//*[contains(@id,'DrpDwnMn0" + index + "')]";
			WebElement menuElement = driver.findElement(By.xpath(xpathExpression));
			hle = new HighLightElement(driver, menuElement);
			menuItemNameList.add(menuElement.getText());
		}
		return menuItemNameList;
	} 

}
