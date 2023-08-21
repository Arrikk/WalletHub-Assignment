package common;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

	public void onTestSuccess​(ITestResult result) {
		Reporter.log("PASSED : TestCase "+ result.getTestName());
	}

	public void onTestFailure(ITestResult result) {

		Reporter.log("FAILED : TestCase "+ result.getTestName());
	}
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("SKIPPED: TestCase "+ result.getTestName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onFinish(ITestResult result) {

	}

}
