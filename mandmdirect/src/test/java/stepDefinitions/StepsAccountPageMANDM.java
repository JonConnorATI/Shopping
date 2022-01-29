package stepDefinitions;





import java.util.List;
import java.util.Map;
import io.cucumber.datatable.*;

import commonMethods.commonMethodsMANDM;
import io.cucumber.java.en.*;
import pageObjects.MyAccountPageMANDM;


public class StepsAccountPageMANDM extends commonMethodsMANDM {
	
	

	@Then("I should be in the Account welcome page")
	public void i_should_be_in_the_account_welcome_page() {
		MyAccountPageMANDM.checkTitle("MandM Direct Welcome");
	}
	
		
	/*
	 * @Then("I should be in the Orders and Returns section") public void
	 * i_should_be_in_the_orders_and_returns_section() {
	 * MyAccountPageMANDM.urlCheck(
	 * "https://www.mandmdirect.ie/Secure/Account/Orders"); }
	 */
	
	@Then("there should be a continue shopping button")
	public void there_should_be_a_continue_shopping_button() {
	    MyAccountPageMANDM.confirmElementValue("Continue Shopping");
	}
	
	/*
	 * @Then("I should be in the Contact Preferences section") public void
	 * i_should_be_in_the_contact_preferences_section() {
	 * MyAccountPageMANDM.urlCheck(
	 * "https://www.mandmdirect.ie/Secure/Account/Mailing"); }
	 */
	
	
	@Then("I will see a checkbox asking if I don't want to be contacted")
	public void i_will_see_a_checkbox_asking_if_i_don_t_want_to_be_contacted() {
		MyAccountPageMANDM.checkboxPresent();
	}
	
	@When("I tick the checkbox")
	public void i_tick_the_checkbox() {
		MyAccountPageMANDM.checkboxtick();
	}
	
	@When("click save")
	public void click_save() {
	    MyAccountPageMANDM.selectSave();
	}
	
	@Then("I will see a confirmation message {string}")
	public void i_will_see_a_confirmation_message(String string) {
	   MyAccountPageMANDM.checkText(string);
	}
	
		
	@Then("I can change the first name and select save so that it will be updated")
	public void i_can_change_the_first_name_and_select_save_so_that_it_will_be_updated() {
		MyAccountPageMANDM.editSaveCheckName();
		
	}
	
	
	@Then("I can change address2 and select save so that it will be updated")
	public void i_can_change_address2_and_select_save_so_that_it_will_be_updated() {
		MyAccountPageMANDM.editSaveCheckAddress();
	}

	@Given("I select the {string} Tab")
	public void i_select_the_tab(String string) {
		MyAccountPageMANDM.SelectTab(string);
	}
	
	@Then("I should be in the {string} section")
	public void i_should_be_in_the_section(String string) {
		MyAccountPageMANDM.urlAccountPageCheck(string);
	}
	

	@When("I select to edit {string} section")
	public void i_select_to_edit_section(String string) {
		MyAccountPageMANDM.selectEditSection(string);
	}


	@Then("I can change the number and select save so that it will be updated")
	public void i_can_change_the_number_and_select_save_so_that_it_will_be_updated() {
		MyAccountPageMANDM.editSaveCheckphone();
	}
	
	@Then("I can change the Date of Birth and select save so that it will be updated")
	public void i_can_change_the_date_of_birth_and_select_save_so_that_it_will_be_updated() {
		MyAccountPageMANDM.editSaveCheckDOBField();
	}
	
	@Then("I can change delivery address and select save so that it will be updated")
	public void i_can_change_delivery_address_and_select_save_so_that_it_will_be_updated() throws InterruptedException {
		MyAccountPageMANDM.editSaveCheckDelAddressField();
	}
	
	@Then("I can change the email and select save so that it will be updated")
	public void i_can_change_the_email_and_select_save_so_that_it_will_be_updated() {
	   MyAccountPageMANDM.enterNewEmail();
	   MyAccountPageMANDM.acceptChanges();
	}

	@Then("change it back again to the original value")
	public void change_it_back_again_to_the_original_value() {
		MyAccountPageMANDM.revertEmail();
	}
	

	@Then("I can change the password and select save so that it will be updated")
	public void i_can_change_the_password_and_select_save_so_that_it_will_be_updated(DataTable dataTable) throws InterruptedException {
		List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
		String currentPassword = data.get(0).get("current password");
		String newPassword = data.get(0).get("new password");
		
		MyAccountPageMANDM.changePassword(currentPassword,newPassword);
		
		
	}

	@Then("I receive a message {string}")
	public void i_receive_a_message(String string) {
		MyAccountPageMANDM.checkAlertText(string);
	}





















}
