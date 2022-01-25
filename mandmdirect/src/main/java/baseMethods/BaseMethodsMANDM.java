package baseMethods;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;

public class BaseMethodsMANDM {

	public static WebDriver driver;

	public static void setDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\JonCo\\git\\Shopping\\Shopping\\mandmdirect\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();

	}

	//open the url
	public static void navigateToHomePage() {
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		String homePage = "https://www.mandmdirect.ie/";
		driver.get(homePage);

	}

	//close the webdriver and clear cookies
	public static void closeDriver() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();

	}

	//Perform a click
	public static void Click(By locator) {
		//new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator)).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	//wait for Element to be present
	public static void WaitForElementToBePresent (By locator) {
		 new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(locator));
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
	

}
