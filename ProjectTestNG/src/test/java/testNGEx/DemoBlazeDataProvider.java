package testNGEx;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DemoBlazeDataProvider {
    WebDriver driver;
    @Test(dataProvider = "dp")
    public void Search(String usernameData, String passwordData) {
        driver.findElement(By.id("login2")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(usernameData);
        driver.findElement(By.id("loginpassword")).sendKeys(passwordData);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        WebElement s =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
    	String s1=s.getText();
    	String s2="Welcome KiotAdmin";
    	Assert.assertEquals(s2, s1,"Login successful");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Start the test");
        driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
        System.out.println("End the test");
    }
    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            { "KiotAdmin", "Kiot@123" }
        };
    }
}