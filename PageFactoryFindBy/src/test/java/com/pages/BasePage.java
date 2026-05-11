package com.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tests.BaseTest;
// To use commonly by all the tester for common locators which can be easily identified by all
public class BasePage {
	protected static final Logger log = LogManager.getLogger(BasePage.class);
	public WebDriver driver;
  public BasePage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	  log.info("Initialize the driver");
  }
}