package com.tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MakeaCall {

    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("96483105520006T");

        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity("com.google.android.dialer.extensions.GoogleDialtactsActivity");

        options.setNoReset(true);
        options.setNewCommandTimeout(java.time.Duration.ofSeconds(3600));

        URL url = new URL("http://127.0.0.1:4723");

        AndroidDriver driver = new AndroidDriver(url, options);

        Thread.sleep(4000);

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.dialer:id/primary_text' and @text='Jananii💞']")).click();

        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"call Jananii💞\"]")).click();


        Thread.sleep(5000);

        boolean callStarted = driver.findElement(
                By.xpath("//*[contains(@content-desc,'End call') or contains(@text,'End')]")
        ).isDisplayed();

        Assert.assertTrue(callStarted, "Call NOT started!");

        System.out.println(" Call successfully initiated");

        driver.findElement(By.xpath("//*[contains(@content-desc,'End call') or contains(@text,'End')]")).click();

        driver.quit();
    }
}