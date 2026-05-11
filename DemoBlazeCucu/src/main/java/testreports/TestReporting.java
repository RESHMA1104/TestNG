package testreports;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReporting {
	public static void main(String[] args) {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		ChromeDriver driver = new ChromeDriver();
		ExtentTest test = extent.createTest("Google Search Test");
		try {
			driver.get("https://google.com"); // driver.get("https://googlee.com"); To fail the report using this
			test.pass("Navigated to Google");
		}
		catch(Exception e){
			test.fail("Test failed due to exception : " +e.getMessage());
		}
		finally {
			driver.quit();
			extent.flush(); // save the report
		}
	}
}