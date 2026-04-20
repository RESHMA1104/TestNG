package testNGEx;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class Test_Assertions {
	WebDriver driver;
  @Test
  public void valid() {
	driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("KiotAdmin");
	driver.findElement(By.id("loginpassword")).sendKeys("Kiot@123");
	driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	WebElement s =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	String s1=s.getText();
	String s2="Welcome KiotAdmin";
	Assert.assertEquals(s2, s1,"Login successful");
	}
  @Test
  public void LoginWrong() {
	driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("Kiot");
	driver.findElement(By.id("loginpassword")).sendKeys("Kiot@123");
	driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert=driver.switchTo().alert();
	String s1=alert.getText();
	String s2="User does not exist.";
	alert.accept();
	Assert.assertEquals(s2, s1,"Login failed");
	}
  @Test
  public void PasswordWrong() {
	driver.findElement(By.id("login2")).click();
	driver.findElement(By.id("loginusername")).sendKeys("KiotAdmin");
	driver.findElement(By.id("loginpassword")).sendKeys("Kiot123");
	driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert=driver.switchTo().alert();
	String s1 = alert.getText();
	String s2 = "Wrong password.";
	alert.accept();
	Assert.assertEquals(s2, s1,"Login failed");
	}
  @BeforeMethod
  public void beforeTest() {
	  ChromeOptions options=new ChromeOptions();
	  driver = new ChromeDriver(options);
	  options.addArguments("---start-maximized--");
	  options.addArguments("--headless");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://demoblaze.com/");
  }
  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }
}