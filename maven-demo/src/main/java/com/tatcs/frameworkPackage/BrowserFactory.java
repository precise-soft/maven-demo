package com.tatcs.frameworkPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class BrowserFactory {

	public static WebDriver driver;
	public BrowserFactory(){

	}
	public static WebDriver getDriver(String browserName){
		if(driver==null){
			if(browserName.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "webdriver\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
				System.out.println("Open a new Firefox...");
				Reporter.log("Open a new Firefox...");
			}else if(browserName.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "webdriver\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
				System.out.println("Open a new Chrome...");
				Reporter.log("Open a new Chrome...");
			}else if(browserName.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver", "webdriver\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
				System.out.println("Open a new Internet Explorer...");
				Reporter.log("Open a new Internet Explorer...");
			}
		}
		return driver;
	}

	
	public void openNewBrowser(String baseURL) {
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		Reporter.log("Maximize the web site: " + baseURL);
	}
}
