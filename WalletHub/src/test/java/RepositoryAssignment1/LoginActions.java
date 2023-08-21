package RepositoryAssignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.DriverWait;

public class LoginActions {

	WebDriver driver;
	String loginUrl = "https://www.facebook.com/";

	/**
	 * Send a get HTTP request to load the required page
	 * 
	 * @param driver
	 */
	public LoginActions(WebDriver driver) {
		this.driver = driver;
		driver.get(loginUrl);
	}

	/**
	 * Initiate the login process providing the login email and password required.
	 * 
	 * @param String email
	 * @param String password
	 */
	public void login(String email, String password) {
		// Using sendKeys method, fill in the email with the provided email
		this.emailField().sendKeys(email);
		// Using sendKeys method fill the password field with the provided password and
		// press the RETURN key
		this.passwordField().sendKeys(password, Keys.RETURN);
//		this.loginButton().click();
	}

	/**
	 * Explicitly wait to Retrieves the email field .
	 * 
	 * @return WebElement
	 */
	private WebElement emailField() {
		WebElement email = DriverWait.explicitly(driver)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"email\"]")));
		return email;
	}

	/**
	 * Explicitly wait to Retrieves the password field .
	 * 
	 * @return WebElement
	 */
	private WebElement passwordField() {
		WebElement password = DriverWait.explicitly(driver)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"pass\"]")));

		return password;
	}

	/**
	 * Check if there is an email error
	 * 
	 * @return Boolean, true if there is an error and false if there is otherwise
	 */
	public Boolean invalidEmail() {
		Boolean result;
		try {
			// Wait for the presence of the invalid email error message and locate it using
			// the given XPath
			WebElement errorIsPresent = DriverWait.explicitly(driver).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"email_container\"]/div[2]")));
			// Confirm if the WebElement error message is displayed
			Boolean isError = errorIsPresent.isDisplayed();
			System.out.println(errorIsPresent);
			// Set the result for indication whether the error message is displayed
			result = isError;
		} catch (Exception e) {
			// If no invalid email error is found, print a message and set the result to
			// false
			System.out.println("No Invalid Email Error");
			result = false;
		}
		return result;
	}

	/**
	 * Check if there is a password error
	 * 
	 * @return Boolean, true if there is an error and false if there is otherwise
	 */
	public boolean invalidPassword() {
		boolean result;
		try {
			// Wait for the presence of the invalid email error message and locate it using
			// the given XPath
			WebElement errorIsPresent = DriverWait.explicitly(driver).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]")));
			// Confirm if the WebElement error message is displayed
			Boolean isError = errorIsPresent.isDisplayed();
			// Set the result for indication whether the error message is displayed
			result = isError;
		} catch (Exception e) {
			// If no invalid password error is found, print a message and set the result to
			// false
			System.out.println("No Invalid Password Error");
			result = false;
		}
		return result;
	}

//	private WebElement loginButton() {
//
//		WebElement button = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"u_0_5_Ox\"]")));
//		return button;
//	}

}
