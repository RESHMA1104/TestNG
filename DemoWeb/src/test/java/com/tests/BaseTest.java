package com.tests;

import java.time.Duration;
import java.util.logging.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import io.opentelemetry.api.logs.Logger;
import jdk.internal.org.jline.utils.Log;

import org.testng.annotations.AfterMethod;
public class BaseTest {
	protected LoginTest objLogin;
	protected DashBoardTest objdb;
	
	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
	
	protected static final Logger log = LogManager.getLogger(BaseTest.class);
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	@BeforeMethod
  public void setup() {
		Log.info("Setup Browser : "+Thread.currentThread());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoblaze.com/");
		Log.info("Launching the Browser");
		threadDriver.set(driver);
  }
	@AfterMethod
	public void tearout() {
		WebDriver driver = getDriver();
		if(driver!=null) {
			driver.quit();
			Log.info("Close the Browser");
			threadDriver.remove();
			}
		}
	}
	
}