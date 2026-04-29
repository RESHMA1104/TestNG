package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class DashBoardPage extends BasePage {
	public DashBoardPage(WebDriver driver) {
		  super(driver);
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
