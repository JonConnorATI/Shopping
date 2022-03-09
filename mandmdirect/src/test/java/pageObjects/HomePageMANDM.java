package pageObjects;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	//Accept cookies to get rid of the pop up, then select login
	public static void goToLogin() {
		acceptCookies();
		selectLoginLink();
		
	}

	//Clears the mini basket (pop up) one item at a time
	public static void clearBasketOther() {
		//Activate the mini basket by hovering over the count icon, then wait for it to appear
		hoverOverElement(By.cssSelector(".icon__count"));
		WaitForElementToBePresent(By.cssSelector(".mini-basket-item__remove"));
				
		//Get the list of the items in the mini basket
		List<WebElement> priceElements = driver.findElements(By.xpath("//*[@class='mini-basket-item__remove']"));
		int n = priceElements.size();
		
		//Select each item and delete them one by one iterating through the list
		for (int i = 0; i < n; i++) {
			refreshPage();
			hoverOverElement(By.cssSelector(".icon__count"));
			WaitForElementToBePresent(By.cssSelector(".mini-basket-item__remove"));
			WaitForElementToBePresent(By.xpath("//*[@class='mini-basket-item__remove']"));
			hoverOverElementAndClick(By.xpath("//*[@class='mini-basket-item__remove']"));
			hoverOverElement(By.cssSelector(".icon__count"));
		}
		
		
	}
	
	public static void clearBasket() {
		hoverOverElement(By.cssSelector(".icon__count"));
		WaitForElementToBePresent(By.cssSelector(".mini-basket-item__remove"));
		WaitForElementToBePresent(By.xpath("//*[@class='mini-basket-item__remove']"));
		hoverOverElementAndClick(By.xpath("//*[@class='mini-basket-item__remove']"));
		
	}
	
	
	

	

}
