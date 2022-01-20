package pageObjects;

import org.openqa.selenium.By;

import baseMethods.BaseMethodsMANDM;

public class HomePageMANDM extends BaseMethodsMANDM{

	public static void selectLoginLink() {
		Click(By.className("myAccount_guest"));
		
	}

	public static void acceptCookies() {
		WaitForElementToBePresent(By.id("onetrust-accept-btn-handler"));
		Click(By.id("onetrust-accept-btn-handler"));
		
	}

}
