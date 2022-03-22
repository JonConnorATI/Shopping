package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
				(
						
				features=".//Features",
				glue="stepDefinitions",
				dryRun=false,
				monochrome=true,
				plugin= {"pretty"},
				publish = true,
				tags = ""
				
				)



public class TestRunMANDM {

}
