package pageObjects;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commonMethods.commonMethodsMANDM;

public class MyAccountPageMANDM extends commonMethodsMANDM {

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
		//waitForPageLoaded() still gave intermittent fails
		//waitForPageLoaded(driver);
		//Changed to wait for the active link (on the page the link section selected turns blue)
		WaitForElementToBePresent(By.xpath("//a[text()='" + link + "']/ancestor::li[@class='active']"));
		
		
	}

	//Check URL of the page
	public static void urlCheck(String string) {
		checkURL(string);
		
	}
	
	//Check URL of the Account Section
	public static void urlAccountPageCheck(String string) {
		checkURL("https://www.mandmdirect.ie/Secure/Account/" + string);
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
	//Check a string of text is as expected
		public static void checkAlertText(String string) {
			WebElement element = driver.findElement(By.cssSelector("#saveConfirmation"));
			String actual = element.getText();
			assertEquals(actual, string);
			
		}
	
	

	//select the edit button to edit Name section
	public static void selectEditName() {
		Click(By.cssSelector("#edit-name-link"));
		waitForPageLoaded(driver);
		
	}
	
	//clear text in 1st name field, enter text, save text and assert it has updated
	public static void editSaveCheckName() {
				
		editSaveCheckTextField(By.cssSelector("#FirstName"),By.xpath("(//*[@class='dl-horizontal']/dd)[2]"));
		
	}

	//Select edit button in cardholder address section
	public static void selectEditAddress() {
		Click(By.cssSelector("#edit-address-link"));
		waitForPageLoaded(driver);
		
	}

	//clear text in address2 field, enter text, save text and assert it has updated
	public static void editSaveCheckAddress() {
		editSaveCheckTextField(By.cssSelector("#Address_AddressLine2"),By.cssSelector("#AddressLine2-Display"));
		
	}

	//Select edit button in the Account page section
	public static void selectEditSection(String string) {
		Click(By.cssSelector("#edit-" + string + "-link"));
		waitForPageLoaded(driver);
		
	}

	//clear text in phone field, enter text, save text and assert it has updated
	public static void editSaveCheckphone() {
		editSaveCheckTextField(By.cssSelector("#PhoneNumber"),By.xpath("(//*[@class='dl-horizontal']/dd)[1]"));
		
	}

	//method to create a random number in the correct format, update date of birth and confirm its been changed
	public static void editSaveCheckDOBField() {
		//Generate random numbers <=9
		Random rand = new Random(System.currentTimeMillis());
		int low = 1;
		int high = 9;
		int day = rand.nextInt(high-low)+low;
		int month = rand.nextInt(high-low)+low;
		
		//make a string of these numbers in the correct format for the date fields
		String dd = "0" + day;
		String mm = "0" + month;
 		String yyyy = "1971";
		String enterDOB = yyyy + "-" + mm + "-" + dd;
		String DOBdisplay = dd + "/" + mm + "/" + yyyy;
		
		//Clear text, enter the date string, save, then assert correct date is displayed
		clearText(By.cssSelector("#DateOfBirth"));
		enterText(By.cssSelector("#DateOfBirth"),enterDOB);
		selectSave();
		WebElement element = driver.findElement(By.xpath("(//*[@class='dl-horizontal']/dd)[1]"));
		String actual = element.getText();
		Assert.assertEquals(actual, DOBdisplay);
		
	}

	//clear text in delivery address field, enter text, save text and assert it has updated
	public static void editSaveCheckDelAddressField() throws InterruptedException {

		String s = RandomStringUtils.randomAlphanumeric(8);
		String locator1 = "#Address_AddressLine1";
		//String locator2 = "#Address_AddressLine1";
		clearText(By.cssSelector(locator1));
		enterText(By.cssSelector(locator1),s);
		selectSave();
		//check the update window has gone and refresh page if still present
		if (isElementPresent(By.cssSelector("#pleaseWaitImage")))
			refreshPage();
		//get the text that was input and saved and check it has updated
		checkElementAttributeText(By.xpath("//*[@class='orderInnerBox']/*[@name='hid.AddressLine1']"), s); 
			
	}
	
	//Enter and confirm new email addresss
	public static void enterNewEmail() {
		String newEmail ="JonathanDublin@sharklasers.com";
		String locator1 = "#EmailAddress"; 
		String locator2 = "#ConfirmEmailAddress"; 
		
		clearText(By.cssSelector(locator1));
		enterText(By.cssSelector(locator1),newEmail);
		clearText(By.cssSelector(locator2));
		enterText(By.cssSelector(locator2),newEmail);
		selectSave();
		
	}
	
	// Accept changes to email address and confirm it has been accepted
	public static void acceptChanges() {
		String newEmail = "JonathanDublin@sharklasers.com";

		Click(By.cssSelector("#delete-confirmation-yes"));
		WaitForElementNotToBePresent(By.cssSelector("#delete-confirmation-yes"));
		WebElement element1 = driver.findElement(By.xpath("(//*[@class='dl-horizontal']/dd)[1]"));
		String actual = element1.getText();
		Assert.assertEquals(actual, newEmail);

	}
	
	//change the email back
	public static void revertEmail() {
		String currentEmail = "JonDublin@sharklasers.com";
		String locator1 = "#EmailAddress";
		String locator2 = "#ConfirmEmailAddress";
		
		Click(By.cssSelector("#edit-email-link"));
		waitForPageLoaded(driver);
		clearText(By.cssSelector(locator1));
		enterText(By.cssSelector(locator1), currentEmail);
		clearText(By.cssSelector(locator2));
		enterText(By.cssSelector(locator2), currentEmail);
		selectSave();
		Click(By.cssSelector("#delete-confirmation-yes"));
		WaitForElementNotToBePresent(By.cssSelector("#delete-confirmation-yes"));

	}

	//change the password to a new value
	public static void changePassword(String currentPassword, String newPassword) throws InterruptedException {
		
		clearText(By.cssSelector("#Password"));
		enterText(By.cssSelector("#Password"), currentPassword);
		clearText(By.cssSelector("#NewPassword"));
		enterText(By.cssSelector("#NewPassword"), newPassword);
		clearText(By.cssSelector("#ConfirmPassword"));
		enterText(By.cssSelector("#ConfirmPassword"), newPassword);
		selectSave();
		Thread.sleep(10000);
		
		
	}
	
	
	



	
	

}
