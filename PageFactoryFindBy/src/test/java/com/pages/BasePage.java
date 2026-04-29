package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
// To use commonly by all the tester for common locators which can be easily identified by all
public class BasePage {
	public WebDriver driver;
  public BasePage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
}