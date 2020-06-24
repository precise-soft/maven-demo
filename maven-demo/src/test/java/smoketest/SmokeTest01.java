package smoketest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SmokeTest01 {
	public WebDriver driver;
	public String browserName;
	public String baseURL="https://www.google.com/"; 

	@Parameters("browser")

	@BeforeClass	// Passing Browser parameter from TestNG xml
	public void beforeClass(String browser) {
		browserName = browser.toLowerCase();

		// If the browser is Firefox, then do this
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("Open Firefox browser...");

		}else if (browser.equalsIgnoreCase("chrome")) { 
			driver = new ChromeDriver();
			Reporter.log("Open Chrome browser...");
		}

		driver.get(baseURL);
		driver.manage().window().maximize();
		Reporter.log("Maximize the web site: " + baseURL);
	}

	@Test
	public void verifySearchButton0() throws InterruptedException {

		String search_text = "Google Search";
		Thread.sleep(2000);
		WebElement search_button = driver.findElement(By.name("btnK"));
		String text = search_button.getAttribute("value");
		Thread.sleep(2000);
		Assert.assertEquals(text, search_text, "Google Search Text not found!");
		Reporter.log("Google Search text is found...3");
	}

	@Test
	public void verifySearchButton1() throws InterruptedException {

		String search_text = "Google Search";
		Thread.sleep(2000);
		WebElement search_button = driver.findElement(By.name("btnK"));
		String text = search_button.getAttribute("value");
		Thread.sleep(2000);
		Assert.assertEquals(text, search_text, "Google Search Text not found!");
		Reporter.log("Google Search text is found...4");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();	
		Reporter.log("Close the browser and end the session...");
	}

}
