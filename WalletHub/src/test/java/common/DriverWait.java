package common;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The DriverWait class provides utility methods for handling various types of waiting in Selenium automation.
 * It includes methods for explicit waits, fluent waits, and custom timeout configurations.
 */
public class DriverWait {

	/**
	 * Mimics a WebDriverWait instance explicitly waiting for 10 seconds.
	 *
	 * @param driver   Instance of WebDriver to be used for waiting.
	 * @return The WebDriverWait instance configured with the given WebDriver.
	 */
	public static WebDriverWait explicitly(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	/**
	 * Mimics and return an instance of WebDriverWait explicitly waiting for specified duration.
	 *
	 * @param driver   Instance of WebDriver to be used for waiting.
	 * @param duration The given duration in seconds that should be explicitly waiting for.
	 * @return The WebDriverWait instance configured with the given WebDriver and the duration.
	 */
	public static WebDriverWait explicitly(WebDriver driver, int duration) {
		return new WebDriverWait(driver, Duration.ofSeconds(duration));
	}
	
	/**
	 * Mimics and return an instance FluentWait fluently waits with a customizable timeout and retry settings.
	 *
	 * @param driver     The WebDriver instance to be used for waiting.
	 * @param timeout    This is the maximum wait time in seconds to fluently wait before timed out
	 * @param retryTime  The time interval, in seconds, between successive polling attempts.
	 * @return A FluentWait instance configured with the specified WebDriver, timeout, and retry settings,
	 *         and configured to ignore NoSuchElementException.
	 */
	public static Wait<WebDriver> fluently(WebDriver driver, int timeout, int retryTime) {
		return new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(timeout))
		.pollingEvery(Duration.ofSeconds(retryTime))
		.ignoring(NoSuchElementException.class);
	}
}
