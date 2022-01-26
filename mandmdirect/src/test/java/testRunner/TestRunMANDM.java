package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
				(
						
				features=".//Features//AccountPage.feature",
				glue="stepDefinitions",
				dryRun=false,
				monochrome=true,
				plugin= {"pretty","html:target/cucumber-reports"},
				publish = true,
				tags = "@test1"
				
				)



public class TestRunMANDM {

}
