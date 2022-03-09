package pageObjects;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import commonMethods.commonMethodsMANDM;

public class MensClothingPageMANDM extends commonMethodsMANDM {

	// Choose the product
	public static void chooseProduct(String product) {
		WaitForElementToBePresent(By.cssSelector("#filter_product h2"));
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

	//Assert that the number in the shopping basket is correct
	//As it is a string, this needs converting into an integer
	//I could have just compared "1" with "1" as the raw string
	//but if any arithmetic is needed I now have a method to get an integer to work with
	public static void shopBasketCount(Integer int1) throws InterruptedException  {
		Thread.sleep(3000);
		WaitForElementToBePresent(By.className("icon__count"));
		WebElement count = driver.findElement(By.className("icon__count"));
						
		int a = Integer.parseInt(count.getText().replaceAll("[^0-9]", ""));
		Assert.assertTrue(int1==a);
		System.out.println("Actual " + a + " is the same as Expected " + int1);
		
	}
	
	//Selects a product and adds to the cart
	public static void addToCart(String string) {
		Click(By.xpath("(//*[@id='productlist']//button[@class='product__quick-buy'])[1]"));
		Click(By.xpath("(//button[@class='attributes__select' and contains(text(),'" + string + "')])[1]"));
		Click(By.xpath("(//*[@class='product__atb buyButton'])[1]"));
		Click(By.cssSelector("#atbClose"));
		
	}
	
	//log out the user
	public static void logOut() {
		Click(By.cssSelector("#logoutlink"));
		
		
	}
	
	
	
	//Hover over the basket and get the item price, then get the cart total and assert they are the same
	public static void checkItemPrice1VScartTotal() {
		//Refresh the page to ensure cart is updated
		refreshPage();
		
		//Hover over the basket item to display the items in the basket
		hoverOverElement(By.cssSelector(".basket__svg"));
		//Check that the basket is displayed and if not then hover over it again
		if(isElementNotPresent(By.xpath("(//*[@id='basketContent']//*[@class='mini-basket-item__price'])[1]")))
			hoverOverElement(By.cssSelector(".basket__svg"));
						
		//Get the price of the items and store it as the integers 'PriceOfItem1', 'PriceOfItem2'
		WaitForElementToBePresent(By.xpath("(//*[@id='basketContent']//*[@class='mini-basket-item__price'])[1]"));
		//Get the price of the item and store it as the String 'PriceOfItem1'
		WebElement itemPrice1 = driver.findElement(By.cssSelector("span[data-bind='text: FormattedTotal']"));
		String PriceOfItem1 = itemPrice1.getText();
		//Close the basket
		Click(By.id("miniBasketClose"));
		
		
		//Get the total of the cart from the summary at the top of the screen and store it as the string 'SumOfCart1'
		WebElement CartSum1 = driver.findElement(By.cssSelector("div[class='text__total'] span[class='notranslate']"));
		String SumOfCart1 = CartSum1.getText();
		
		//Assert that 'PriceOfItem1' is the same as 'Sum of Cart1'
		Assert.assertEquals(PriceOfItem1, "€" + SumOfCart1);
		System.out.println("Price of Item is " + PriceOfItem1 + " is the same as the Cart Total €" + SumOfCart1);
		
		}
	
	public static void checkItemPriceCartTotal() {
		
		long PriceOfItems = (long) AddItemPricesSumAgainstCartTotal();
		WebElement CartSum = driver.findElement(By.cssSelector("div[class='text__total'] span[class='notranslate']"));
		long SumOfCart = Integer.parseInt(CartSum.getText().replaceAll("[^0-9]", ""));
		Assert.assertEquals(PriceOfItems, SumOfCart);
		System.out.println("Total Price of Items is €" + PriceOfItems + " is the same as the Cart Total €" + SumOfCart);
		
		
		
		
	}

	public static double AddItemPricesSumAgainstCartTotal() {
		refreshPage();
		hoverOverElement(By.cssSelector(".basket__svg"));
		if(isElementNotPresent(By.xpath("(//*[@id='basketContent']//*[@class='mini-basket-item__price'])[1]")))
			hoverOverElement(By.cssSelector(".basket__svg"));
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//*[@id='basketContent']//*[@class='mini-basket-item__price']"));
		int n = priceElements.size();
		Double[] priceArray = new Double[n];
		
		
		double sum = 0;
		for (int i = 0; i < n; i++) {
			priceArray[i] = Double.parseDouble(priceElements.get(i).getText().replaceAll("[^0-9]", ""));
			sum += priceArray[i];
			
		}
		return sum;
		
	}
	
	
	
	
	
	
	
	
	
		
		/*
		
		//Refresh the page to ensure cart is updated
		refreshPage();
		
		//Hover over the basket item to display the items in the basket
		hoverOverElement(By.cssSelector(".basket__svg"));
		//Check that the basket is displayed and if not then hover over it again
		if(isElementNotPresent(By.xpath("(//*[@id='basketContent']//*[@class='mini-basket-item__price'])[1]")))
			hoverOverElement(By.cssSelector(".basket__svg"));
				
		//Get the price of the items and store it as the integers 'PriceOfItem1', 'PriceOfItem2'
		WaitForElementToBePresent(By.xpath("(//*[@id='basketContent']//*[@class='mini-basket-item__price'])[1]"));
		WebElement itemPrice1 = driver.findElement(By.xpath("(//*[@id='basketContent']//*[@class='mini-basket-item__price'])[1]"));
		long PriceOfItem1 = Integer.parseInt(itemPrice1.getText().replaceAll("[^0-9]", ""));
		WebElement itemPrice2 = driver.findElement(By.xpath("(//*[@id='basketContent']//*[@class='mini-basket-item__price'])[2]"));
		long PriceOfItem2 = Integer.parseInt(itemPrice2.getText().replaceAll("[^0-9]", ""));
		long PriceOfItems = PriceOfItem1 + PriceOfItem2;
		//Close the basket
		Click(By.id("miniBasketClose"));
				
		//Get the total of the cart from the summary at the top of the screen and store it as the integer 'SumOfCart1'
		WebElement CartSum1 = driver.findElement(By.cssSelector("div[class='text__total'] span[class='notranslate']"));
		long SumOfCart1 = Integer.parseInt(CartSum1.getText().replaceAll("[^0-9]", ""));
				
		//Assert that 'PriceOfItem1' is the same as 'Sum of Cart1'
		Assert.assertEquals(PriceOfItems, SumOfCart1);
		System.out.println("Total Price of Items is €" + PriceOfItems + " is the same as the Cart Total €" + SumOfCart1);
				
		}*/
	

}


	
	
	


