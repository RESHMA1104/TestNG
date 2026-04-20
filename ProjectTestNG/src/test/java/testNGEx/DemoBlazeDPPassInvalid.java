package testNGEx;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DemoBlazeDPPassInvalid {
    WebDriver driver;
    @Test(dataProvider = "Test")
    public void Search(String usernameData, String passwordData) {
        driver.findElement(By.id("login2")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(usernameData);
        driver.findElement(By.id("loginpassword")).sendKeys(passwordData);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(15));
    	wait1.until(ExpectedConditions.alertIsPresent());
    	Alert alert=driver.switchTo().alert();
    	String s1=alert.getText();
    	String s2="Wrong password.";
    	alert.accept();
    	Assert.assertEquals(s2, s1,"Login failed");
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
    @DataProvider(name = "Test")
    public Object[][] dp() {
        return new Object[][] {
            { "KiotAdmin", "Kiot123" }
        };
    }
}