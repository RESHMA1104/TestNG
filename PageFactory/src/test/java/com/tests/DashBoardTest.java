package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;
public class DashBoardTest extends BaseTest{
	DashBoardPage objDashBoardPage;
	@Test(priority =0)
public void Dashboard() {
	LoginPage objLogin;
	  objLogin = new LoginPage(driver);
	  objLogin.login("Admin", "admin123");
	  objDashBoardPage = new DashBoardPage(driver);
	  Assert.assertTrue(objDashBoardPage.getHomePageText().contains("Dashboard"));
	  }
  }