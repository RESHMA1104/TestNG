package testNGEx;
import org.testng.annotations.DataProvider;
public class DPClass {
	@DataProvider(name="testData",parallel=true)
	public Object[][] dataprovfunc(){
		return new Object[][] {{"Selenium"},{"TestNG"},{"Automation"}};
	}
}