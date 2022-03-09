package stepDefinitions;

import commonMethods.commonMethodsMANDM;
import io.cucumber.java.en.*;
import pageObjects.HomePageMANDM;
import pageObjects.LoginPageMANDM;
import pageObjects.MensClothingPageMANDM;
import pageObjects.MyAccountPageMANDM;

public class StepsCartIsCachedMANDM extends commonMethodsMANDM {
	

	@Given("I log into my account as the Test User")
	public void i_log_into_my_account_as_the_test_user() {
		navigateToHomePage();
		HomePageMANDM.goToLogin();
		LoginPageMANDM.enterUsername("JonDublin@sharklasers.com");
		LoginPageMANDM.enterPassword("Clogg9711");
		LoginPageMANDM.pressLoginButton();
		LoginPageMANDM.checkTitle("MandM Direct Welcome");
	}
	@Given("I want to go shopping")
	public void i_want_to_go_shopping() {
	    MyAccountPageMANDM.goshopping();
	   
	}
	
	@And("add them to the cart size {string}")
	public void add_them_to_the_cart_size(String string) {
		MensClothingPageMANDM.addToCart(string);
	}
		
	@Given("that I log out")
	public void that_i_log_out() {
	    MensClothingPageMANDM.logOut();
	}
	@Then("the shopping basket count will be {int}")
	public void the_shopping_basket_count_will_be(Integer int1) throws InterruptedException {
		MensClothingPageMANDM.shopBasketCount(int1);
	}
	
	@Given("I log into my account again as the Test User")
	public void i_log_into_my_account_again_as_the_test_user() {
		HomePageMANDM.selectLoginLink();
		LoginPageMANDM.enterUsername("JonDublin@sharklasers.com");
		LoginPageMANDM.enterPassword("Clogg9711");
		LoginPageMANDM.pressLoginButton();
		MyAccountPageMANDM.goshopping();
		
	}

	@Given("that I clear the basket")
	public void that_i_clear_the_basket() {
		
		HomePageMANDM.clearBasket();
		
		
	}








}
