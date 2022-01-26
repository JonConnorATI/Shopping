package pageObjects;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	//Select a tab from side menu
	public static void SelectTab(String link) {
		Click(By.linkText(link));
		waitForPageLoaded(driver);
		
	}

	//Check URL of the page
	public static void urlCheck(String string) {
		checkURL(string);
		
	}
	
	//Assert element attribute 'value' is as expected
	public static void confirmElementValue(String string) {
		checkElementAttributeText(By.cssSelector(".btn.btn-danger.span12"),string);
		
	}
	
	//confirm checkbox is present
	public static void checkboxPresent() {
		isElementPresent(By.cssSelector(".checkmark"));
		
	}

	//tick checkbox
	public static void checkboxtick() {
		Click(By.cssSelector(".checkmark"));
		
	}

	//select save
	public static void selectSave() {
		Click(By.cssSelector("#btnSave"));
		waitForPageLoaded(driver);
		
	}

	//Check a string of text is as expected
	public static void checkText(String string) {
		WebElement element = driver.findElement(By.xpath("//*[@id='saveConfirmation']/p"));
		String actual = element.getText();
		assertEquals(actual, string);
		
	}

	//select the edit button to edit Name section
	public static void selectEditName() {
		Click(By.cssSelector("#edit-name-link"));
		waitForPageLoaded(driver);
		
	}
	
	//method to clear text field, enter text, save text and assert it has updated
	public static void editSaveCheckName() {
		String s = RandomStringUtils.randomAlphanumeric(8);
		
		clearText(By.cssSelector("#FirstName"));
		enterText(By.cssSelector("#FirstName"),s);
		selectSave();
		WebElement element = driver.findElement(By.xpath("(//*[@class='dl-horizontal']/dd)[2]"));
		String actual = element.getText();
		assertEquals(actual, s);
		
	}

	public static void selectEditAddress() {
		Click(By.cssSelector("#edit-address-link"));
		waitForPageLoaded(driver);
		
	}

	public static void editSaveCheckAddress() {
		String s = RandomStringUtils.randomAlphanumeric(8);
		
		clearText(By.cssSelector("#Address_AddressLine2"));
		enterText(By.cssSelector("#Address_AddressLine2"),s);
		selectSave();
		WebElement element = driver.findElement(By.cssSelector("#AddressLine2-Display"));
		String actual = element.getText();
		assertEquals(actual, s);
		
	}
	
	

}
