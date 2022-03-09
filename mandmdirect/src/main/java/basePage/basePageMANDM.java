package basePage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basePageMANDM {
	
	//Declare the webdriver 
	public static WebDriver driver;

	//Set the webdriver that all scenarios use
	public static void setDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\JonCo\\git\\Shopping\\mandmdirect\\Drivers\\chromedriver.exe");
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

}