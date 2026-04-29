package com.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.utilities.DPExcel;

public class DashBoardTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(DashBoardTest.class);

	@Test(priority = 1, dataProvider = "validData", dataProviderClass = DPExcel.class)
	public void loginvalidTest(String username, String password) {
		objLogin = new LoginPage(getDriver());

		objLogin.login(username, password);
		 log.info("Login attempted with credentials");
		objDashboardPage = new DashBoardPage(getDriver());

		String dashboardPageTitle = objDashboardPage.getHomePageText();
		 log.info("Dashboard page title retrieved: " + dashboardPageTitle);
		Assert.assertTrue(dashboardPageTitle.contains("Dashboard"));
		 log.info("loginValidTest PASSED.");

	}
}