package pageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import baseMethods.BaseMethodsMANDM;

public class MyAccountPageMANDM extends BaseMethodsMANDM {

	//Asserts the page title is correct
	public static void checkTitle(String title) {
		assertEquals(driver.getTitle(), (title));
		
	}

	//Selects the Continue Shopping button
	public static MensClothingPageMANDM goshopping() {
		Click(By.cssSelector(".btn.btn-danger.span12"));
		
		return new MensClothingPageMANDM();
		
	}

}
