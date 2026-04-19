package testNGEx;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class NewTest {
    public WebDriver driver;    
    @Test
    public void validation() {
        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys("KiotAdmin");
        driver.findElement(By.id("loginpassword")).sendKeys("Kiot@123");
    }
    @BeforeTest
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");  
        driver = new ChromeDriver(options);  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoblaze.com/");
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}