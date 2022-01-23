package pageObjects;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import baseMethods.BaseMethodsMANDM;

public class MensClothingPageMANDM extends BaseMethodsMANDM {

	// Choose the product
	public static void chooseProduct(String product) {
		Click(By.cssSelector("#filter_product h2"));
		Click(By.xpath("//span[@class='product'and text()='" + product + "']"));

	}

	// Choose the size
	public static void chooseSize(String size) {
		Click(By.cssSelector("#filter_size > .filter__heading"));
		Click(By.xpath("//span[@class='size'and text()='" + size + "']"));

	}

	// Choose the product type
	public static void chooseProductType(String type) {
		//
		Click(By.cssSelector("#filter_producttype h2"));
		Click(By.xpath("//span[@class='product type'and text()='" + type + "']"));
	}

	// Select what to sort by eg Cheapest
	public static void sortBy(String sortBy) {

		System.out.println("Going to sort by " + sortBy);
		driver.findElement(By.id("sortByTop")).sendKeys(Keys.RETURN, Keys.ARROW_DOWN, Keys.RETURN);
		System.out.println("Now Sorted by " + sortBy);

	}

	/*
	 * Create a list of all the prices in the order they appear on screen.Then Make 2
	 * arrays from this list. #1 is the original and #2 is sorted in ascending order. Compare the 2
	 * arrays and if they are identical it verifies the original order is correct.
	 */
	public static void checkFirstItem(String string) {

		List<WebElement> priceElements = driver.findElements(By.cssSelector(".product__selling-price.notranslate"));
		int n = priceElements.size();
		Double[] priceArray = new Double[n];
		Double[] priceArrayCopy = new Double[n];

		for (int i = 0; i < n; i++) {
			priceArray[i] = Double.parseDouble(priceElements.get(i).getText().replaceAll("[^0-9]", ""));
			priceArrayCopy[i] = Double.parseDouble(priceElements.get(i).getText().replaceAll("[^0-9]", ""));
		}

		Arrays.sort(priceArray);
		Assert.assertTrue(Arrays.equals(priceArray, priceArrayCopy));

		System.out.println("This is the Onscreen list: ");
		System.out.println(Arrays.toString(priceArray));
		System.out.println("This is the same list sorted. They match so the 'SortBy' on screen is correct");
		System.out.println(Arrays.toString(priceArrayCopy));

	}

	public static void shopBasketCount(Integer int1) throws InterruptedException  {
		Thread.sleep(3000);
		WaitForElementToBePresent(By.className("icon__count"));
		WebElement count = driver.findElement(By.className("icon__count"));
						
		int a = Integer.parseInt(count.getText().replaceAll("[^0-9]", ""));
		Assert.assertTrue(int1==a);
		System.out.println("Actual " + a + " is the same as Expected " + int1);
		
	}

	public static void addToCart() {
		Click(By.xpath("(//*[@id='productlist']//button[@class='product__quick-buy'])[1]"));
		Click(By.xpath("(//button[@class='attributes__select' and contains(text(), 'Waist 36')])[1]"));
		Click(By.xpath("(//*[@class='product__atb buyButton'])[1]"));
		Click(By.cssSelector("#atbClose"));
		
	}

	public static void logOut() {
		Click(By.cssSelector("#logoutlink"));
		
		
	}

	
	
	

}
