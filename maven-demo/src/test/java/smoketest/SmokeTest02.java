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

	@SuppressWarnings("static-access")
	@Parameters("browser")

	@BeforeClass	// Passing Browser parameter from TestNG xml
	public void beforeClass(String browser) {
		browserName = browser.toLowerCase();

		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver(browser);
		bf.openNewBrowser(baseURL);

	}

	@Test
	public void verifyADPLogin() throws InterruptedException {
		ADPLoginPage alp = PageFactory.initElements(driver, ADPLoginPage.class);
		alp.login("test", " ");
		assertEquals(alp.getErrorMessage(), "Logon attempt failed");
		Reporter.log("Verify that the error message of 'Logon attempt failed' is found.");
		
		assertTrue(alp.isTextExist("Logon attempt failed"), "The error message of 'Logon attempt failed' is not found.");
	}


	@AfterClass
	public void afterClass() {
		driver.quit();	
		Reporter.log("Close the browser and end the session...");
	}

}
