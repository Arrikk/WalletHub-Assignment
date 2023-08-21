package RepositoryAssignment1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FbAlert {

	public static void hasAlert(WebDriver driver) {
		try {
			System.out.println("Checking For Alerts");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();
		} catch (Exception e) {
			return;
		}
	}
}
