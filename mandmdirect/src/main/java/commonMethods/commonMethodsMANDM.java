package commonMethods;




import java.time.Duration;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePage.basePageMANDM;


//import cucumber.api.java.After;
//import cucumber.api.java.Before;

public class commonMethodsMANDM  extends basePageMANDM{

	

	//Perform a click
	public static void Click(By locator) {
		//new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator)).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	//wait for Element to be present
	public static void WaitForElementToBePresent (By locator) {
		 new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//wait for element to NOT be present
	public static void WaitForElementNotToBePresent (By locator) {
		WebElement element = driver.findElement(locator);
		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.invisibilityOf(element));
	}

	//enter text into a field
	public static void enterText(By locator, String text) {
		driver.findElement((locator)).sendKeys(text);

	}

	//Checks if an element is present
	public static boolean isElementPresent(By locator) {
		if (driver.findElements(locator).size() != 0) {
			return true;
		} else {
			return false;
		}

	}

	//Checks an element is enabled
	public static boolean isElemententEnabled(By locator) {
		if (driver.findElement(locator).isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	//Checks an element is not present
	public static boolean isElementNotPresent(By locator) {
		if (driver.findElements(locator).size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	//mouse over an element
	public static void hoverOverElement(By locator) {
		WebElement element = driver.findElement((locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	//Clear text in a field
	public static void clearText(By locator) {
		driver.findElement(locator).clear();
		
	}
 
	//mouse over an element and click
	public static void hoverOverElementAndClick(By locator) {
		WebElement element = driver.findElement((locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		action.click().build().perform();
		
	}
	
	//Get the URL of a page and assert it is the same as the expected URL
	public static void checkURL(String url) {
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, url);
		
	}
	
	

	//Gets the value of an elements attribute and asserts it is the same as the expected value
	public static void checkElementAttributeText (By locator, String ExptdText) {
		String ActText = driver.findElement(locator).getAttribute("value");
		System.out.println("actual is: " + ActText + " and Expctd is: " + ExptdText);
		Assert.assertEquals(ActText, ExptdText);
		
	}
	
	//Wait for a page to load
	public static void waitForPageLoaded(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}
	}
	
	//Method to clear text in a field, update the field with a random string, save the entry and assert it displays correctly
	public static void editSaveCheckTextField(By locator1, By locator2) {
		
		String s = RandomStringUtils.randomAlphanumeric(8);
		
		clearText(locator1);
		enterText((locator1),s);
		save();
		WebElement element = driver.findElement(locator2);
		String actual = element.getText();
		Assert.assertEquals(actual, s);
		
	}
	
	//Method to click a save button
	public static void save() {
		Click(By.cssSelector("#btnSave"));
		waitForPageLoaded(driver);
		
	}
	
	//Method to refresh the page
	public static void refreshPage() {
		driver.navigate().refresh();
		waitForPageLoaded(driver);
	}

}
