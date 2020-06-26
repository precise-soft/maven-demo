package smoketest;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tatcs.frameworkPackage.BrowserFactory;
import com.tatcs.frameworkPackage.CaptureScreenShot;
import com.tatcs.uiPackage.GoogleSearchPage;
import com.tatcs.uiPackage.TTHomePage;


public class SmokeTest01 {

	private GoogleSearchPage gsp;

	public WebDriver driver;
	public CaptureScreenShot capture;

	public String browserName;
	public String baseURL="https://www.google.com/"; 

	@SuppressWarnings("static-access")
	@Parameters("browser")

	@BeforeClass	// Passing Browser parameter from TestNG xml
	public void beforeClass(String browser, ITestContext context) {
		browserName = browser.toLowerCase();

		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver(browser);
		bf.openNewBrowser(baseURL);

		context.setAttribute("WebDriver", driver);	//Save WebDriver to Test Context
	}

	@Test (priority = 0)
	public void verifyTandTPageTitle() throws InterruptedException {
		// Create GoogleSearchPage object
		gsp = PageFactory.initElements(driver, GoogleSearchPage.class);

		String searchText ="T and T Consulting Services"; 
		gsp.enterSearch(searchText);
		Assert.assertTrue(gsp.isSearchResultExisted(searchText), "The hyperlink of " + searchText + " is not found!");
		Reporter.log("Verify that the hyperlink of '" + searchText + "' is found.");
		System.out.println("Verify that the hyperlink of '" + searchText + "' is found.");

		gsp.clickLink(searchText);
		Assert.assertTrue(gsp.isTextExisted(searchText), "The text of " + searchText + " is not found.");
		Reporter.log("Verify that the text of '" + searchText + "' is found.");
		System.out.println("Verify that the text of '" + searchText + "' is found.");

	}

	@SuppressWarnings("unused")
	@Test (priority = 1)
	public void verifyTandTHomePage() throws InterruptedException {

		TTHomePage tthp = PageFactory.initElements(driver, TTHomePage.class);

		//Verify that the text of Company Information
		Assert.assertTrue(tthp.isTextExisted("Company Information"), "The text of Company Information is not found.");
		Reporter.log("Verify that the text of Company Information is found.");
		System.out.println("Verify that the text of Company Information is found.");

		//Verify that the text of Eligible for SBA 8(a) Program Competitive
		Assert.assertTrue(tthp.isTextExisted("Eligible for SBA 8(a) Program Competitive"), "The text of Eligible for SBA 8(a) Program Competitive is not found.");
		Reporter.log("Verify that the text of Eligible for SBA 8(a) Program Competitive is found.");
		System.out.println("Verify that the text of Eligible for SBA 8(a) Program Competitive is found.");

		// Verify main menu items
		List<String> menuItemList = Arrays.asList("About", "Solutions & Services", "Clients", "Contract Vehicles", "Careers", "Contact");
		boolean isEqual = menuItemList.equals(tthp.getMenuItems());
		Assert.assertTrue(isEqual, "The text of the main menu is not matched");
		Reporter.log("The main menu text is verified.");
		System.out.println("The main menu text is verified.");

	}


	@AfterClass
	public void afterClass() {
		driver.quit();
		Reporter.log("Close the browser and end the session...");
	}

}
