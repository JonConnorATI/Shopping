package pageObjects;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;

import commonMethods.commonMethodsMANDM;

public class LoginPageMANDM extends commonMethodsMANDM {

	// Enter username or email
	public static void enterUsername(String username) {
		enterText(By.id("EmailAddress"), username);

	}

	// Enter password
	public static void enterPassword(String password) {
		enterText(By.id("Password"), password);

	}

	// Press the login button
	public static void pressLoginButton() {
		Click(By.cssSelector(".disableableContinueButton"));
		waitForPageLoaded(driver);

	}

	// Assert the error message is displayed
	public static void checkLoginErrorMessage() {
		assertEquals(driver.findElement(By.xpath("//*[@class='validation-summary-errors']//li")).getText(),
				("Oops! You've entered an incorrect email address or password. Please try again."));

	}

	// Assert the page title matches the expected page title
	public static MyAccountPageMANDM checkTitle(String title) {
		assertEquals(driver.getTitle(), (title));

		return new MyAccountPageMANDM();

	}

}
