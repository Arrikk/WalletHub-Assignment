package repositoryAssignment2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import common.DriverWait;


/**
 * The ReviewActions class provides a structured approach to interact with review-related actions on a web page.
 * It encapsulates methods to navigate to a specific URL, scroll to reviews, change policy selections, write comments,
 * and submit reviews. The class utilizes WebDriver for interaction and follows a modular structure to enhance
 * maintainability and readability.
 * This class aims to facilitate seamless automation of review-related tasks, such as interacting with star ratings,
 * policy dropdowns, text areas, and submission buttons, by abstracting away the underlying details of the interactions.
 * It also integrates explicit waits to ensure that the required web elements are visible before performing actions,
 * thus contributing to reliable test automation.
 */
public class ReviewActions {

	WebDriver driver;
	By reviewsContainerSelector = By.cssSelector("div.rv.review-action.ng-enter-element");
	By starsRatingsSelector = By.cssSelector("div.rv.review-action.ng-enter-element > .rvs-svg > div > svg");
	By dropdownPolicySelector = By.cssSelector("ng-dropdown.wrev-drp div[zing-touch]");
	By policiesSelector = By.cssSelector("ng-dropdown.wrev-drp div[zing-touch] > ul > li");
	By textAreaSelector = By.cssSelector("div.textarea-user > textarea");
	By submitButtonSelector = By.cssSelector(" write-review > sub-navigation div[role=\"button\"]");
	private final String url = "https://wallethub.com/profile/13732055i";
	private final String policyToSelect = "Health Insurance";
	private final int positionOfStar = 4;
	
	/**
	 * ReviewActions class provides methods to interact with review-related actions on a web page.
	 * It initializes the WebDriver and offers functionalities such as scrolling to reviews,
	 * changing policy selection, writing comments, and submitting reviews.
	 */
	public ReviewActions(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
	}

	/**
     * Constructs a new ReviewActions instance with the specified WebDriver and navigates to the given URL.
     *
     * @param driver The WebDriver instance to be used for interacting with the web page.
     */
	public boolean scrollToReview() throws InterruptedException {
		try {
			Actions actions = new Actions(driver);
			actions.scrollToElement(this.reviews()).perform();

			List<WebElement> stars = this.stars();
			// Iterate over the lists starting from the first element to send nearest end of the list
			//
			for (int i = 0; i < stars.size() - 1; i++) {
				WebElement star = stars.get(i);
				// Starting from 0 - the length of the stars
				// subtracting 1 knowing to click the 4th occurence of the star
				if (i == positionOfStar-1) {
					actions.moveToElement(star).click().build().perform();
				} else {
					actions.moveToElement(star).perform();
				}

			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			return false;
		}
		return true;

	}

	/**
     * Changes the policy selection.
     *
     * @return true if the policy is changed successfully, false otherwise.
     */
	public boolean changePolicy() {
		try {
			this.select().click();
			List<WebElement> policies = this.policies();

			for (WebElement policy : policies) {
				// Looping through the policies.. Get the policy that 
				// the text is "Health Insurance" and perform a click
				String text = policy.getText();
				if (text.equals(policyToSelect)) {
					policy.click();
					// Break out of the loop
					break;
				}
			}
			return true;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			return false;
		}

	}

	/**
     * Writes a comment in the text area.
     *
     * @param comment The comment to be written.
     * @return true if the comment is written successfully and meets length requirements, false otherwise.
     */
	public boolean writeComment(String comment) {
		try {
			this.textArea().sendKeys(comment);
			return comment.length() >= 200 ? true : false;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	 /**
     * Submits the review.
     *
     * @return true if the review is submitted successfully, false otherwise.
     */
	public boolean submitReview() {
		try {
			this.submitButton().click();
			return true;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			return false;
		}
	}

	private WebElement reviews() {
		WebElement webElement = DriverWait.explicitly(driver)
				.until(ExpectedConditions.visibilityOfElementLocated(reviewsContainerSelector));
		return webElement;
	}

	private List<WebElement> stars() {
		List<WebElement> webElements = DriverWait.explicitly(driver)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(starsRatingsSelector));
		return webElements;
	}

	private WebElement select() {
		WebElement webElement = DriverWait.explicitly(driver)
				.until(ExpectedConditions.visibilityOfElementLocated(dropdownPolicySelector));
		return webElement;
	}

	private List<WebElement> policies() {
		List<WebElement> webElements = DriverWait.explicitly(driver)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(policiesSelector));
		return webElements;
	}

	private WebElement textArea() {
		WebElement textarea = driver.findElement(textAreaSelector);
		return textarea;
	}

	private WebElement submitButton() {
		WebElement button = driver.findElement(submitButtonSelector);
		return button;
	}

}
