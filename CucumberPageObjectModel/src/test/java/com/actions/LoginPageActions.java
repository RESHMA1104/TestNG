package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.pages.LoginPageLocators;
import com.utils.HelperClass;

public class LoginPageActions {

    LoginPageLocators loginpageLocators = null;

    String strUsername, strPassword;

    public LoginPageActions() {
        this.loginpageLocators = new LoginPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), loginpageLocators);
    }

    public void setStrUserName(String strUserName) {
        this.loginpageLocators.userName.sendKeys(strUserName);
    }

    public void setStrPassWord(String strPassWord) {
        this.loginpageLocators.passWord.sendKeys(strPassWord);
    }
    public void clickLogin() {
    	loginpageLocators.login.click();
    }

    public void login() {

        File file = new File("src\\test\\resources\\TestData.properties");
        FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		strUsername = prop.getProperty("username");
		System.out.println("Username : " + strUsername);

		strPassword = prop.getProperty("password");
		System.out.println("Password : " + strPassword);

		this.setStrUserName(strUsername);
		this.setStrPassWord(strPassword);
		this.clickLogin();
	}
}