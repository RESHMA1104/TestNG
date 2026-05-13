package com.actions;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.HomePageLocators;
import com.utils.HelperClass;

public class HomePageActions {
   HomePageLocators homePageLocators=null;
   public HomePageActions() {
	   this.homePageLocators=new HomePageLocators();
	   PageFactory.initElements(HelperClass.getDriver(), homePageLocators);
   }
   
   public String getHomePageText() {
	   WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(),Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.visibilityOf(homePageLocators.homePageUserName));

	    return homePageLocators.homePageUserName.getText();
	  
   }
}