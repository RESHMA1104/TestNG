package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;
	By username = By.xpath("//input[@name='username']");
	By password = By.name("//input[@name='password']");
	By titleText = By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
	By login = By.xpath("//button[@type='submit']");

  public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
@Test
  public void setUserName(String strUserName) {
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(strUserName);
  }
  public void setPassword(String strPassword) {
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPassword);
  }
  public String getLoginTitle() {
	  return driver.findElement(titleText).getText();
  }
  public void clickLogin() {
	  driver.findElement(login).click();
  }
  public void login(String strUserName, String strPassword) {
	  this.setUserName(strUserName);
	  this.setPassword(strPassword);
	  this.clickLogin();
  }
}
// allow all origin to remove warnings[ --allowAllOrigin in options  ]