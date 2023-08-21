package assignment;

import org.testng.annotations.Test;

import RepositoryAssignment1.LoginActions;
import RepositoryAssignment1.PostStatusActions;
import common.BaseAssignment;

import org.testng.Assert;
import org.testng.SkipException;


@Test
public class Assignment1 extends BaseAssignment {
	
	String loginEmail = ""; //Enter email in this variable.
	String loginPassword = ""; // Enter password in this variable
	String statusText = "Hello World!";

	/**
	 * Test case to verify if login is successful using the provided email and
	 * password 
	 * Step1: Create an instance of LoginActions class.
	 * Ensure email and password is not empty before proceed
	 * Step2: Perform login using the provided login email and password. 
	 * Step3: Check for invalid email and invalid password errors. 
	 * Step4: Verify that the login is successful by ensuring no invalid login errors. 
	 * If either invalid email or invalid password error is
	 * present, the test fails.
	 */

	@Test(priority=1)
	public void testLogin() {
		// Create an instance of LoginActions class
		LoginActions login = new LoginActions(driver);
		
		if(!loginEmail.isBlank() || !loginPassword.isBlank()) {
			// Perform login using the provided login email and password
			login.login(loginEmail, loginPassword);
	
			Boolean invalidEmail = login.invalidEmail();
			Boolean invalidPassword = login.invalidPassword();
	
			// Verify that the login is successful by ensuring no invalid login errors
			// If either invalid email or invalid password error is present, the test fails
			Boolean invalidLogin = invalidEmail || invalidPassword;
			Assert.assertEquals(invalidLogin, false);
		}else {
			Assert.assertTrue(false);
		}
	}

	/**
	 * Test case to post a status update on the user's Facebook account.
	 * Step1: Create an instance of PostStatusActions class.
	 * Step2: Check if the user is on the home page.
	 * Step3: If on the home page:
	 * ---- Set up to post a status update.
	 * ---- Enter the provided status text.
	 * ---- Post the status update.
	 * Step4. If not on the home page, skip the test and throw a SkipException with the
	 * message "User Not LoggedIN".
	 */
	@Test(priority=2)
	public void postStatus() {
		// Create an instance of PostStatusActions class.
		PostStatusActions home = new PostStatusActions(driver);
		// Check if the user is on the home page
		if (home.isHomePage()) {
	        // Set up to post a status update, enter the provided status text, and post
			home.isReadyToPost().typeText(statusText).post();
		} else {
	        // If not on the home page, skip the test and throw a SkipException
			throw new SkipException("User Not LoggedIN");
		}
	}

}
