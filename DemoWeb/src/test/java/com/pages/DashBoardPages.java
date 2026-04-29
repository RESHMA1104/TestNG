package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class DashBoardPages extends BasePages {
	public DashBoardPages(WebDriver driver) {
		  super(driver);
		  }
	@FindBy(id="nameofuser")
	public WebElement dbPageTitle;
	@Test
	public String getHpText() {
	  return dbPageTitle.getText();
  }
}