package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="projectfeatures",
		glue="stepDefinitions",
		tags = { "~@ignore" } 
		)
public class LoginRunner {

}
