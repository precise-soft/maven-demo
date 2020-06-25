package com.tatcs.uiPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tatcs.frameworkPackage.HighLightElement;

public class ADPLoginPage {
	WebDriver driver;
	HighLightElement hle, hle1;
	public ADPLoginPage(WebDriver driver){
		this.driver=driver;
	}

	@FindBy(how=How.XPATH,using="/html/body/div[3]/div[1]/div[2]/div[2]/div/h1")
	@CacheLookup
	WebElement pageTitle;

	@FindBy(how=How.NAME,using="user")
	@CacheLookup
	WebElement userName;

	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	WebElement password;

	@FindBy(how=How.ID,using="subBtn")
	@CacheLookup
	WebElement signInButton;
	
	public void login(String userNameText, String passwordText) {
		try {
			hle = new HighLightElement(driver,userName);
			userName.sendKeys(userNameText);
			Thread.sleep(1000);
			hle1 = new HighLightElement(driver,password);
			password.sendKeys(passwordText);
			Thread.sleep(1000);
			signInButton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getErrorMessage() {
		String message= null;
		try {
			WebElement textElement = driver.findElement(By.cssSelector(".titlesred"));
			Thread.sleep(1000);
			message = textElement.getText();
		}
		catch( InterruptedException e) {
			e.printStackTrace();
		}
		return message;
	}

	public boolean isTextExist(String targetText) {
		boolean exist= false;
		try {
			String xpathExpression = "//*[contains(text(),'" + targetText+ "')]";
			WebElement target = driver.findElement(By.xpath(xpathExpression));
			Thread.sleep(1000);
			exist = target.isEnabled();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		return exist;
	}

}
