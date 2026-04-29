package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages extends BasePages{
	public LoginPages(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="login2")
	public WebElement loginbutton;
	@FindBy(id="loginusername" )
	public WebElement username;
	@FindBy(id="loginpassword")
	public WebElement password;
	@FindBy(xpath = "//button[@onclick='logIn()']")
	public WebElement login;

  public void login(String strUserName, String strPassword) {
	  loginbutton.click();
	  username.sendKeys(strUserName);
	  password.sendKeys(strPassword);
	  login.click();
  }
}