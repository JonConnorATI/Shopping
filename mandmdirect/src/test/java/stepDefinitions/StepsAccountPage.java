package stepDefinitions;





import baseMethods.BaseMethodsMANDM;
import io.cucumber.java.en.*;
import pageObjects.MyAccountPageMANDM;

public class StepsAccountPage extends BaseMethodsMANDM {
	
	

	@Then("I should be in the Account welcome page")
	public void i_should_be_in_the_account_welcome_page() {
		MyAccountPageMANDM.checkTitle("MandM Direct Welcome");
	}
	
	@Given("I select the Orders and Return Tab")
	public void i_select_the_orders_and_return_tab() {
		MyAccountPageMANDM.SelectTab("Orders and Returns");
	}
	
	@Then("I should be in the Orders and Returns section")
	public void i_should_be_in_the_orders_and_returns_section() {
	    MyAccountPageMANDM.urlCheck("https://www.mandmdirect.ie/Secure/Account/Orders");
	}
	
	@Then("there should be a continue shopping button")
	public void there_should_be_a_continue_shopping_button() {
	    MyAccountPageMANDM.confirmElementValue("Continue Shopping");
	}
	
	
	@Given("I select the Contact Preferences Tab")
	public void i_select_the_contact_preferences_tab() {
		MyAccountPageMANDM.SelectTab("Contact Preferences");
	}
	
	@Then("I should be in the Contact Preferences section")
	public void i_should_be_in_the_contact_preferences_section() {
		MyAccountPageMANDM.urlCheck("https://www.mandmdirect.ie/Secure/Account/Mailing");
	}
	
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

	@Given("I select the Customer Name Tab")
	public void i_select_the_customer_name_tab() {
		MyAccountPageMANDM.SelectTab("Customer Name");
	}
	
	@Then("I should be in the Customer Name section")
	public void i_should_be_in_the_customer_name_section() {
		MyAccountPageMANDM.urlCheck("https://www.mandmdirect.ie/Secure/Account/Customer");
	}
	
	@When("I select to edit the name")
	public void i_select_to_edit_the_name() {
	    MyAccountPageMANDM.selectEditName();
	}
	
	@Then("I can change the first name and select save so that it will be updated")
	public void i_can_change_the_first_name_and_select_save_so_that_it_will_be_updated() {
		MyAccountPageMANDM.editSaveCheckName();
		
	}

	@Given("I select the Cardholder Address Tab")
	public void i_select_the_cardholder_address_tab() {
		MyAccountPageMANDM.SelectTab("Cardholder Address");
	}
	
	@Then("I should be in the Cardholder Address section")
	public void i_should_be_in_the_cardholder_address_section() {
		MyAccountPageMANDM.urlCheck("https://www.mandmdirect.ie/Secure/Account/Address");
	}
	@When("I select edit")
	public void i_select_edit() {
		MyAccountPageMANDM.selectEditAddress();
	}
	@Then("I can change address2 and select save so that it will be updated")
	public void i_can_change_address2_and_select_save_so_that_it_will_be_updated() {
		MyAccountPageMANDM.editSaveCheckAddress();
	}










}
