package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DashBoardPage {
	WebDriver driver;
	By dashboardPage = By.xpath("//h6[normalize-space()='Dashboard']");
  public DashBoardPage(WebDriver driver) {
	  this.driver = driver;
	  }
@Test
  public String getHomePageText() {
	  return driver.findElement(dashboardPage).getText();
  }
  // for reusable pass a parameter as WebElement element and give that element to get the text
}
