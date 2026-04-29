package com.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.DashBoardPage;
import com.pages.LoginPage;


public class LoginTest extends BaseTest {
	LoginPage objLogin;
	
  @Test(priority =0)
  public void loginTest() {
	  // create login page object
	  objLogin = new LoginPage(driver);
	  // verify login page text
	  String loginpageTitle = objLogin.getLoginTitle();
	  Assert.assertTrue(loginpageTitle.contains("Login"));
  }
}
