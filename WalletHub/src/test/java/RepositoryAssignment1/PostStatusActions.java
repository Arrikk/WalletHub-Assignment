package RepositoryAssignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.DriverWait;

public class PostStatusActions {
	WebDriver driver;
	String homeURL = "https://facebook.com/home.php";
	String statusBoxContainerSelector = "div[aria-label=\"Create a post\"]";
	String statusInputContainerSelector = "div[aria-label=\"Create a post\"] > div > div";
	String statusInputFieldSelector = "div[contenteditable=\"true\"]";
	String postButtonSelector = "form > div > div > div > div > div > div:nth-child(3) > div:nth-child(2) > div > div";
	/**
	 * form > div > div > div > div > div > div:nth-child(2) > div > div > .x9f619.x1iyjqo2
	 * Send a get HTTP request to load the required page
	 * 
	 * @param driver
	 */
	public PostStatusActions(WebDriver driver) {
		this.driver = driver;
		driver.get(homeURL);
	}

	public boolean isHomePage() {
		try {
			Boolean canPost = DriverWait.explicitly(driver)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(statusBoxContainerSelector)))
					.isDisplayed();
			System.out.println("Yes It Got it");
			return canPost;
		} catch (Exception e) {
			System.out.println("Could not get the page...");
			return false;
		}
	}

	public PostStatusActions isReadyToPost() {
		this.postInputBox().click();
		return this;

	}
	
	public PostStatusActions typeText(String text)
	{
		this.textinputBox().sendKeys(text);
		return this;
	}
	
	public void post()
	{
		this.postButton().click();
	}

	private WebElement postInputBox() {
		System.out.println("I am Ready To Post Please...");
		return DriverWait.explicitly(driver).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(statusInputContainerSelector)));
	}
	
	private WebElement textinputBox() {
		System.out.println("Now Type...");
		return DriverWait.explicitly(driver).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(statusInputFieldSelector)));
	}
	
	private WebElement postButton() {
		System.out.println("Now Post...");
		return DriverWait.explicitly(driver).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(postButtonSelector)));
	}

}
