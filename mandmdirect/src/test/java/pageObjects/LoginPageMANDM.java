package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import baseMethods.BaseMethodsMANDM;

public class LoginPageMANDM extends BaseMethodsMANDM {

	public static void enterUsername(String username) {
		enterText(By.id("EmailAddress"), username);
		
	}

	public static void enterPassword(String password) {
		enterText(By.id("Password"),password);
		
	}

	public static void pressLoginButton() {
		Click(By.cssSelector(".disableableContinueButton"));
		
	}

	public static void checkLoginErrorMessage() {
		assertEquals(driver.findElement(By.xpath("//*[@class='validation-summary-errors']//li")).getText(), ("Oops! You've entered an incorrect email address or password. Please try again."));
		
	}

	

}
