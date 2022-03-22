package stepDefinitions;

import java.io.IOException;

import commonMethods.commonMethodsMANDM;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class StepsBaseMANDM extends commonMethodsMANDM {
	
	@Before()
	public void setup() throws IOException {

		setDriver();
	}

	@After()
	public void tearDown() {

		closeDriver();
	}

}
