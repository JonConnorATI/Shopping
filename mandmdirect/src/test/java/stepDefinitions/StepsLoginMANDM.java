package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import commonMethods.commonMethodsMANDM;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.HomePageMANDM;
import io.cucumber.datatable.*;

import pageObjects.LoginPageMANDM;

public class StepsLoginMANDM extends commonMethodsMANDM {

	@Before()
	public void setup() throws IOException {

		setDriver();
	}

	@After()
	public void tearDown() {

		closeDriver();
	}

	@Given("I open the website and select sign in")
	public void i_open_the_website_and_select_sign_in() throws InterruptedException {
		
		navigateToHomePage();
		HomePageMANDM.goToLogin();
		
	}

	@When("^I enter email ([^\"]*) and password ([^\\\"]*) then press login$")
	public void i_enter_email_and_password_then_press_login(String username, String password) {

		LoginPageMANDM.enterUsername(username);
		LoginPageMANDM.enterPassword(password);
		LoginPageMANDM.pressLoginButton();
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
	
	@When("I enter email <username> and current password <password> then press login")
	public void i_enter_email_username_and_current_password_password_then_press_login(DataTable dataTable) {
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		LoginPageMANDM.enterUsername(data.get(0).get("username"));
		LoginPageMANDM.enterPassword(data.get(0).get("password"));
		LoginPageMANDM.pressLoginButton();
	}





	
	
	




}