package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
	    features = "src/test/resources/com/features/LoginTutorials.feature",
	    glue = "stepDefinitions"
	)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}