package pageObjects;

import static org.junit.Assert.assertEquals;

import baseMethods.BaseMethodsMANDM;

public class MyAccountPageMANDM extends BaseMethodsMANDM {

	public static void checkTitle(String title) {
		assertEquals(driver.getTitle(), (title));
		
	}

}
