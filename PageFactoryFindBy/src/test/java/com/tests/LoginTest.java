package com.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.utilities.DPExcel;
@Listeners(listeners.class)
public class LoginTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(LoginTest.class);

    @Test(priority = 0)
    public void loginPageTitleTest() {

        log.info("Starting loginPageTitleTest");

        objLogin = new LoginPage(getDriver());
        String loginPageTitle = objLogin.getLoginPageText();

        log.info("Login page title: " + loginPageTitle);

        
        Assert.assertTrue(loginPageTitle.contains("Login"));

        log.info("loginPageTitleTest PASSED");
    }

    @Test(priority = 1,
          dataProvider = "validData",
          dataProviderClass = DPExcel.class)
    public void loginValidTest(String username, String password) {

        log.info("Starting loginValidTest");

        objLogin = new LoginPage(getDriver());
        objLogin.login(username, password);

        objDashboardPage = new DashBoardPage(getDriver());
        String dashboardPageTitle = objDashboardPage.getHomePageText();

        log.info("Dashboard title: " + dashboardPageTitle);

       
        Assert.assertTrue(dashboardPageTitle.contains("Dashboard"));

        log.info("loginValidTest PASSED for user: " + username);
    }

    @Test(priority = 2,
          dataProvider = "invalidData",
          dataProviderClass = DPExcel.class)
    public void loginInvalidTest(String username, String password) {

        log.info("Starting loginInvalidTest");
        objLogin = new LoginPage(getDriver());
        objLogin.login(username, password);

        String actual = objLogin.getInvalidMessage();
        String expected = "Invalid credentials";
        log.info("Error message: " + actual);

       
        Assert.assertEquals(actual, expected);
        log.info("loginInvalidTest PASSED for user: " + username);
    }
}