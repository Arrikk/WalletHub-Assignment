package assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseAssignment;
import repositoryAssignment2.ReviewActions;

public class Assignment2 extends BaseAssignment {

	String url = "https://wallethub.com/profile/13732055i";
	String comment = "A health insurance policy provides you with financial assistance at the time of a medical emergency. "
			+ "Health risks and uncertainties are part of life. Hence, it is important you opt for a health insurance plan "
			+ "that caters to your changing health insurance requirements/needs. Since health insurance is a yearly renewable contract, "
			+ "it is significant you review your health insurance plan to ensure you do not end up paying for the medical expenses from your pocket.";
	ReviewActions actions;

	@Test(priority = 1)
	public void reviewProfile() throws InterruptedException {
		this.actions = new ReviewActions(driver);
		actions.scrollToReview();
	}

	@Test(priority = 2, dependsOnMethods = "reviewProfile")
	public void changePolicy() {
		boolean changedPolicy = actions.changePolicy();
		Assert.assertTrue(changedPolicy);
	}

	@Test(priority = 3, dependsOnMethods = "changePolicy")
	public void writeComment() {
		boolean writtenComment = actions.writeComment(comment);
		Assert.assertTrue(writtenComment);
	}

	@Test(priority = 4, dependsOnMethods = "writeComment")
	public void submitReview() {
		boolean writtenComment = actions.submitReview();
		Assert.assertTrue(writtenComment);
	}

	@Test(enabled = false)
	public void login() {
		Assert.assertTrue(true);
	}
}
