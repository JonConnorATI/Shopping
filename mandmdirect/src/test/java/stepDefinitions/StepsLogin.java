package stepDefinitions;

import java.io.IOException;

import baseMethods.BaseMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class StepsLogin extends BaseMethods {
	
	@Before()
	public void setup() throws IOException {

		setDriver();
	}

	@After()
	public void tearDown() {

		closeDriver();
	}
	
	@Given("I open the website and go to sign in")
	public void i_open_the_website_and_go_to_sign_in() throws InterruptedException {
		navigateToHomePage();
		//HomePage.acceptCookies();
		HomePage.selectLoginLink();
	}
	
	@When("^The ([^\"]*) is entered into the username field$")
	public void the_is_entered_into_the_username_field(String username) {
		
		LoginPage.enterUsername(username);
	}
	
	@When("^([^\"]*) is entered into the password field$")
	public void is_entered_into_the_password_field(String password) throws Throwable {

		LoginPage.enterPassword(password);
	}
	
	@When("I press Login")
	public void i_press_login() {
		
		LoginPage.pressLoginButton();
	}
	
	@Then("^There should be ([^\"]*) message displayed$")
	public void there_should_be_message_displayed(String errorMessage) throws Throwable {
		if (errorMessage == "An Error") {

			LoginPage.checkLoginErrorMessage();

		} else {
			MyAccountPage.checkTitle("My account - Offbeat Donuts");

		}

	}

}