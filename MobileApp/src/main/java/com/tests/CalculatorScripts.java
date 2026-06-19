package com.tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorScripts {

    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid("96483105520006T");
        options.setAppPackage("com.vivo.calculator");
        options.setAppActivity("com.vivo.calculator.Calculator");
        options.setNoReset(true);

        URL url = new URL("http://127.0.0.1:4723");

        AndroidDriver driver = new AndroidDriver(url, options);

        driver.findElement(By.id("com.vivo.calculator:id/digit1")).click();
        driver.findElement(By.id("com.vivo.calculator:id/plus")).click();
        driver.findElement(By.id("com.vivo.calculator:id/digit2")).click();
        driver.findElement(By.id("com.vivo.calculator:id/equal")).click();

        String result = driver.findElement(By.id("com.vivo.calculator:id/input_edit")).getText();
        String actualResult = driver.findElement(By.id("com.vivo.calculator:id/input_edit")).getText();
        System.out.println("Result is: " + actualResult);

        String expectedResult = "3";
        Assert.assertEquals(actualResult, expectedResult, "Calculation Failed!");
        System.out.println("Test Passed");
        driver.quit();
    }
}