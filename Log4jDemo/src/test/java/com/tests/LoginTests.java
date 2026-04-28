package com.tests;
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
import org.testng.annotations.*;
import com.utilities.ExcelUtilities;

public class LoginTests {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver.set(new ChromeDriver(options));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().get("https://www.demoblaze.com/");
    }

    @Test(dataProvider = "validData", dataProviderClass = ExcelUtilities.class)
    
    public void validLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username);
        driver.get().findElement(By.id("loginpassword")).sendKeys(password);
        driver.get().findElement(By.xpath("//button[text()='Log in']")).click();
        WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        Assert.assertTrue(welcome.getText().contains(username));
        System.out.println("VALID LOGIN PASSED: " + username);
    }
    
    @Test(dataProvider = "invalidData", dataProviderClass = ExcelUtilities.class)
   
    public void invalidLogin(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username);
        driver.get().findElement(By.id("loginpassword")).sendKeys(password);
        driver.get().findElement(By.xpath("//button[text()='Log in']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String msg = alert.getText();
        alert.accept();
        Assert.assertTrue(msg.contains("Wrong password") || msg.contains("User does not exist"));
        System.out.println("INVALID LOGIN PASSED: " + username);
    }
    
    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}