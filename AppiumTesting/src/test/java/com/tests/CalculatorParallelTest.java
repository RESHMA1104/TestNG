package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorParallelTest {

    @Test
    @Parameters({"udid", "port", "systemPort"})
    public void testCalculator(String udid, String port, String systemPort) throws Exception {

        AndroidDriver driver = DriverFactory.createDriver(udid, port, systemPort);
        CalculatorLocators loc = CalculatorLocators.forDevice(udid);

        System.out.println("Running on device: " + udid);

        try {
            driver.findElement(By.id(loc.digit1)).click();
            driver.findElement(By.id(loc.plus)).click();
            driver.findElement(By.id(loc.digit2)).click();
            driver.findElement(By.id(loc.equal)).click();

            String result = driver.findElement(By.id(loc.resultField)).getText();
            System.out.println("Result is: " + result);

            Assert.assertEquals(result, "3", "Calculation Failed!");
            System.out.println("Test Passed on: " + udid);
        } finally {
            driver.quit();
        }
    }
}