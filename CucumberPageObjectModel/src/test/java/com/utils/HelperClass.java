package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HelperClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        // Ignore SSL certificate errors
        options.setAcceptInsecureCerts(true);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");

        WebDriver driver1 = new ChromeDriver(options);
        driver.set(driver1);

        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver1.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void openPage(String url) {
        getDriver().get(url);
    }

    public static void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}