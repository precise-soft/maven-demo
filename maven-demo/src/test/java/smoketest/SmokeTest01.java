package smoketest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tatcs.frameworkPackage.BrowserFactory;
import com.tatcs.uiPackage.GoogleSearchPage;


public class SmokeTest01 {
	public WebDriver driver;
	public String browserName;
	public String baseURL="https://www.google.com/"; 

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
	public void verifyTandTPageTitle() throws InterruptedException {
		// Create GoogleSearchPage object
		GoogleSearchPage gsp = PageFactory.initElements(driver, GoogleSearchPage.class);
		
		String searchText ="T and T Consulting Services"; 
		gsp.enterSearch(searchText);
		Assert.assertTrue(gsp.isSearchResultExisted(searchText), "The hyperlink of " + searchText + " is not found!");
		Reporter.log("Verify that the hyperlink of '" + searchText + "' is found.");
		
		gsp.clickLink(searchText);
		Assert.assertTrue(gsp.isTextExisted(searchText), "The text of " + searchText + " is not found.");
		Reporter.log("Verify that the text of '" + searchText + "' is found.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		Reporter.log("Close the browser and end the session...");
	}

}
