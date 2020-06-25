package com.tatcs.uiPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tatcs.frameworkPackage.HighLightElement;


public class GoogleSearchPage {

	WebDriver driver = null;
	HighLightElement hle, hle1;
	
	@FindBy(how=How.NAME,using="q")
	@CacheLookup
	WebElement searchField;
	
	@FindBy(how=How.NAME,using="btnK")
	@CacheLookup
	WebElement googleSearchButton;
	
	public GoogleSearchPage(WebDriver driver){
		this.driver=driver;
	}

    static GoogleSearchPage init(WebDriver webDriver) {
        return new GoogleSearchPage(webDriver);
    }
	
	public void enterSearch(String searchText) {
		try {
			hle = new HighLightElement(driver, searchField);
			searchField.sendKeys(searchText);
			Thread.sleep(1000);
			
			hle1 = new HighLightElement(driver, googleSearchButton);
			googleSearchButton.click();
			Thread.sleep(1000);
			
		}catch (InterruptedException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isSearchResultExisted(String searchText) {
		WebElement targetText = driver.findElement(By.partialLinkText(searchText));
		hle = new HighLightElement(driver, targetText);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetText.isDisplayed();
	}

	public void clickLink(String clickableText) {
		String xpathExpression = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/a[1]/h3";
		WebElement link = driver.findElement(By.xpath(xpathExpression));
		hle = new HighLightElement(driver, link);
		try {
			if (link.isDisplayed()) {
				link.click();
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isTextExisted(String targetText) {
		WebElement bodyTextEle = driver.findElement(By.tagName("body"));
		hle = new HighLightElement(driver, bodyTextEle);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bodyTextEle.getText().contains(targetText);
	}


}
