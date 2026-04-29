package parameterdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class DemoBlazePara {
	public WebDriver driver;
	@Parameters({"browser", "url"})
  @Test
  public void setup(String browser, String Url) {
		if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @BeforeTest
  @Parameters({"Username", "Password"})
  public void before(String Username, String Password) {
		driver.findElement(By.id("login2")).click();;
		driver.findElement(By.id("loginusername")).sendKeys(Username);
		driver.findElement(By.id("loginpassword")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
