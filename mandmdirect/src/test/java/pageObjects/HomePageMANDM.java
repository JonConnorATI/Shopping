package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import commonMethods.commonMethodsMANDM;

public class HomePageMANDM extends commonMethodsMANDM{

	public static void selectLoginLink() {
		Click(By.className("myAccount_guest"));
		
	}
	
	//Closes when accept cookies is selected so not needed
	/*
	 * public static void signUpClose() {
	 * WaitForElementToBePresent(By.id("signUpModalClose"));
	 * Click(By.id("signUpModalClose"));
	 * 
	 * }
	 */
	
	//Accept cookies to remove the cover from the screen
	public static void acceptCookies() {

		WaitForElementToBePresent(By.id("onetrust-accept-btn-handler"));
		Click(By.id("onetrust-accept-btn-handler"));

	}

	//Select the link for mens 
	public static MensClothingPageMANDM SelectMensLink() {
		Click(By.id("mens"));
		assertEquals(driver.getTitle(), ("Cheap Mens Trainers & Clothing | Up To 75% Off | MandM Direct"));
	
		return new MensClothingPageMANDM();
		
	}

	public static void goToLogin() {
		acceptCookies();
		selectLoginLink();
		
	}

	

}
