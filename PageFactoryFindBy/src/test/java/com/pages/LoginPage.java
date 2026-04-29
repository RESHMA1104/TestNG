package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@name='username']" )
	public WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
	public WebElement login_text;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement login;
	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	public WebElement message;

  public void login(String strUserName, String strPassword) {
	  username.sendKeys(strUserName);
	  password.sendKeys(strPassword);
	  login.click();
  }
  public String getLoginPageText() {
	  return login_text.getText();
  }
  public String getInvalidMessage() {
	  return message.getText();
  }
}
// allow all origin to remove warnings[ --allowAllOrigin in options  ]