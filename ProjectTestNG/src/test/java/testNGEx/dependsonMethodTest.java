package testNGEx;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class dependsonMethodTest {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void validation() {
        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
            .sendKeys("KiotAdmin");

        driver.findElement(By.id("loginpassword")).sendKeys("Kiot@123");
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
    }

    @Test(dependsOnMethods = "validation")
    public void validation_1() {
        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
            .sendKeys("Admin");

        driver.findElement(By.id("loginpassword")).sendKeys("Kiot@123");
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
    }

    @Test(dependsOnMethods = "validation")
    public void validation_2() {
        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
            .sendKeys("KiotAdmin");

        driver.findElement(By.id("loginpassword")).sendKeys("Kiot123");
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
    }

    @BeforeMethod
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoblaze.com/");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}