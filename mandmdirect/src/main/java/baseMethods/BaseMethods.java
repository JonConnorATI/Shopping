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

public class BaseMethods {

	public static WebDriver driver;

	public static void setDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\JonCo\\git\\MandMDirectIE\\mandmdirect\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public static void navigateToHomePage() {
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		String homePage = "https://www.mandmdirect.ie/";
		driver.get(homePage);

	}

	public static void closeDriver() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();

	}

	
	public static void Click(By locator) {
		//new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator)).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public static void WaitForElementToBePresent (By locator) {
		 new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	

	public static void enterText(By locator, String text) {
		driver.findElement((locator)).sendKeys(text);

	}

	public static boolean isElementPresent(By locator) {
		if (driver.findElements(locator).size() != 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isElemententEnabled(By locator) {
		if (driver.findElement(locator).isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isElementNotPresent(By locator) {
		if (driver.findElements(locator).size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void hoverOverElement(By locator) {
		WebElement element = driver.findElement((locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public static void clearText(By locator) {
		driver.findElement(locator).clear();
	}

	

}
