package pageObjects;

import org.openqa.selenium.By;

import baseMethods.BaseMethods;

public class HomePage extends BaseMethods{

	public static void selectLoginLink() {
		Click(By.className("myAccount_guest"));
		
	}

}
