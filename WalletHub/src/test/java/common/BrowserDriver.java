package common;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriver {
	
	public static WebDriver drive(String browser) {
		
		WebDriver driver;
		
		switch (browser) {
		case "chrome":
			driver = BrowserDriver.chromeDriver();
			break;
		case "firefox":
			driver = BrowserDriver.firefoxDriver();
			break;
		case "edge":
			driver = BrowserDriver.edgeDriver();
			break;
		case "safari":
			driver = BrowserDriver.safariDriver();
			break;
		default:
			driver = BrowserDriver.chromeDriver();
			break;
		}
		
		return driver;
	}
	
	private static ChromeDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return new ChromeDriver(options);
	}
	
	private static FirefoxDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-notifications");
		return new FirefoxDriver(options);
	}
	
	private static EdgeDriver edgeDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}
	
	private static SafariDriver safariDriver() {
		WebDriverManager.safaridriver().setup();
//		SafariOptions options = new SafariOptions();
		return new SafariDriver();
	}
	
	
}
