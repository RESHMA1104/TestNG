package testNGEx;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class GroupsFormatting {
	WebDriver driver;
	@Test(groups = "groupA")
	  public void Valid() {
		  driver.findElement(By.id("login2")).click();
		  driver.findElement(By.id("loginusername")).sendKeys("KiotAdmin");
	      driver.findElement(By.id("loginpassword")).sendKeys("Kiot@123");
	      driver.findElement(By.xpath("//button[text()='Log in']")).click();
	  }
  @Test(groups = "groupB")
  public void PasswordWrong() {
	  driver.findElement(By.id("login2")).click();
	  driver.findElement(By.id("loginusername")).sendKeys("KiotAdmin");
      driver.findElement(By.id("loginpassword")).sendKeys("1234");
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
  }
  @Test(dependsOnGroups = "groupA")
  public void LoginWrong() {
	  driver.findElement(By.id("login2")).click();
	  driver.findElement(By.id("loginusername")).sendKeys("Kiot");
      driver.findElement(By.id("loginpassword")).sendKeys("Kiot@123");
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");
      driver = new ChromeDriver(options);  
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get("https://demoblaze.com/");
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}