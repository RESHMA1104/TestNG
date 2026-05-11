package com.definitions;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.HelperClass;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static final Logger logger =
            LogManager.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario) {

        HelperClass.setUpDriver();

        logger.info("Scenario started: {}", scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            File screenshotFile =
                    ((TakesScreenshot) HelperClass.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            try {

                File destFile = new File(
                        "screenshots/"
                        + scenario.getName().replaceAll(" ", "_")
                        + ".png");

                FileUtils.copyFile(screenshotFile, destFile);

                byte[] screenshotBytes =
                        ((TakesScreenshot) HelperClass.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshotBytes,
                        "image/png",
                        "Failure Screenshot");

                logger.error(
                        "Scenario failed: {}",
                        scenario.getName());

            }

            catch (IOException e) {

                logger.error(
                        "Failed to take screenshot: {}",
                        e.getMessage());
            }
        }

        else {

            logger.info(
                    "Scenario passed: {}",
                    scenario.getName());
        }

        HelperClass.tearDown();

        logger.info(
                "Scenario ended: {}",
                scenario.getName());
    }
}