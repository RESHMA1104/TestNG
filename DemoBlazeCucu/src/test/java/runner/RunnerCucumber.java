package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty", "html:target.cucumber-reports/Cucumber.html"},
//features = "src/test/resources/cucumberFeature/login.feature",
features = "src/test/resources/cucumberFeature/DemoBlazeLoginSO.feature",
glue = "stepDefinition"
)
public class RunnerCucumber extends AbstractTestNGCucumberTests{
	
}