package common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseAssignment {
	protected WebDriver driver;
	
	/**
	 * Assignment1 set up method to make an initialization of the WebDriver 
	 * based on the specified browser.
	 * 
	 * @param browser, browser parameter set from TestNG XML suite.
	 *  Example values: "chrome", "firefox", etc.
	 * 
	 * Step1. Make an initialization of the BrowserDriver class making as an assignment
	 * to the global driver property.
	 */
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		// Make an initialization of the BrowserDriver class making as an assignment
		// to the global driver property
		this.driver = BrowserDriver.drive(browser);
	}
	
	
	/**
	 * Quit the driver after all tests are executed
	 */
	@AfterClass(enabled = false)
	public void tearDown() {
		driver.quit();
	}
}
