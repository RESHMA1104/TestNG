package com.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.tests.BaseTest;

public class DashBoardPage extends BasePage {
	protected static final Logger log = LogManager.getLogger(DashBoardPage.class);
	public DashBoardPage(WebDriver driver) {
		  super(driver);
		  log.info("Getting a DashboardPageTitle");
		  }
	@FindBy(xpath ="//h6[normalize-space()='Dashboard']")
	public WebElement dashboardPageTitle;
	
	@Test
	// Get the username from the home page
	public String getHomePageText() {
	  return dashboardPageTitle.getText();
  }
  // for reusable pass a parameter as WebElement element and give that element to get the text
}
