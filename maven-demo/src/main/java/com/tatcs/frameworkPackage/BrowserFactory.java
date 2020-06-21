package com.tatcs.frameworkPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
public static WebDriver driver;
public BrowserFactory() {
	
}
public static WebDriver getDriver() {
	if (driver == null) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver(options);
		openBrowser(driver);
	}
	return driver;
}


public static WebDriver getDriver(String browserName){
	if(driver==null){
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
			openBrowser(driver);
			System.out.println("Open Firefox browser...");
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
			openBrowser(driver);
			System.out.println("Open Chrome browser...");
		}else if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
			openBrowser(driver);
			System.out.println("Open Internet Explorer browser...");
			}
	}
	return driver;
}

private static WebDriver openBrowser(WebDriver currentDriver) {
	currentDriver.manage().window().maximize();
	currentDriver.manage().deleteAllCookies();
	currentDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	currentDriver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	return currentDriver;
}


}
