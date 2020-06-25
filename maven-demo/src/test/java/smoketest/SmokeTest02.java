package smoketest;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tatcs.frameworkPackage.BrowserFactory;
import com.tatcs.uiPackage.ADPLoginPage;


public class SmokeTest02 {
	public WebDriver driver;
	public String browserName;
	public String baseURL="https://workforcenow.adp.com/workforcenow/login.html"; 
	ADPLoginPage alp; 

	@SuppressWarnings("static-access")
	@Parameters("browser")

	@BeforeClass	// Passing Browser parameter from TestNG xml
	public void beforeClass(String browser) {
		browserName = browser.toLowerCase();

		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver(browser);
		bf.openNewBrowser(baseURL);
		alp = PageFactory.initElements(driver, ADPLoginPage.class);
	}

	@Test(priority = 0)
	public void verifyADPLoginPage() throws InterruptedException {

		assertTrue(alp.isTextExist("Welcome to ADP"), "The page title of 'Welcome to ADP' is not found.");
		Reporter.log("The page title of 'Welcome to ADP' is not found.");
		System.out.println("The page title of 'Welcome to ADP' is not found.");
		
		assertTrue(alp.isLinkExist("Forgot your user ID/password?"), "The hyperlink of 'Forgot your user ID/password' is not found.");
		Reporter.log("Verify that the hyperlink of 'Forgot your user ID/password?' is found.");
		System.out.println("Verify that the hyperlink of 'Forgot your user ID/password?' is found.");
		
		assertTrue(alp.isLinkExist("These is no way!"), "The hyperlink of 'Administrator Sign In' is not found.");
		Reporter.log("Verify that the hyperlink of 'Administrator Sign In' is found.");
		System.out.println("Verify that the hyperlink of 'Administrator Sign In' is found.");
		
	}

	@Test (priority = 1)
	public void verifyADPLogin() throws InterruptedException {

		alp.login("test", " ");
		assertEquals(alp.getErrorMessage(), "Logon attempt failed");
		Reporter.log("Verify that the error message of 'Logon attempt failed' is found.");
		System.out.println("Verify that the error message of 'Logon attempt failed' is found.");
		
		assertTrue(alp.isTextExist("We cannot find your account with the information you entered."), "The page content of 'We cannot find your account with the information you entered.' is not found.");
		Reporter.log("The page content of 'We cannot find your account with the information you entered.' is not found.");
		System.out.println("The page content of 'We cannot find your account with the information you entered.' is not found.");
	}


	@AfterClass
	public void afterClass() {
		driver.quit();	
		Reporter.log("Close the browser and end the session...");
	}

}
