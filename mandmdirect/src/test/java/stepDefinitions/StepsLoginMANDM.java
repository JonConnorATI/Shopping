package stepDefinitions;

import java.io.IOException;

import baseMethods.BaseMethodsMANDM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.HomePageMANDM;

import pageObjects.LoginPageMANDM;

public class StepsLoginMANDM extends BaseMethodsMANDM {

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
		HomePageMANDM.acceptCookies();
		HomePageMANDM.selectLoginLink();
	}

	@When("^The ([^\"]*) is entered into the username field$")
	public void the_is_entered_into_the_username_field(String username) {

		LoginPageMANDM.enterUsername(username);
	}

	@When("^([^\"]*) is entered into the password field$")
	public void is_entered_into_the_password_field(String password) throws Throwable {

		LoginPageMANDM.enterPassword(password);
	}

	@When("I press Login")
	public void i_press_login() {

		LoginPageMANDM.pressLoginButton();
	}

	@Then("There should be An Error message displayed")
	public void there_should_be_an_error_message_displayed() {

		LoginPageMANDM.checkLoginErrorMessage();

	}

	@Then("There should be No Error message displayed")
	public void there_should_be_no_error_message_displayed() {
		System.out.println("In the else section");
		LoginPageMANDM.checkTitle("MandM Direct Welcome");

	}

}