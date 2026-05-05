package stepDefinition;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoBlazeLoginSOStepDefinition {
	WebDriver driver;
	
	@Given("the user is on Home Page")
	public void the_user_is_on_home_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user clicks on login link")
	public void user_clicks_on_login_link() {
		driver.findElement(By.id("login2")).click();
	}

	@When("user enters username as {string} and password as {string}>")
	public void user_enters_username_as_and_password_as(String username, String password) {
		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);
	}

	@When("the user clicks on login button")
	public void the_user_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[@onclick=\"logIn()\"]")).click();
	}

	@Then("the error message should be displayed as \"\"User does not exist.\"\"")
	public void the_error_message_should_be_displayed_as_User_does_not_exist() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String s1 = alert.getText();
		String s2 = "User does not exist.";
		alert.accept();
		Assert.assertEquals(s2, s1,"Login failed");
	}

	@Then("the error message should be displayed as \"\"Wrong password.\"\"")
	public void the_error_message_should_be_displayed_as_wrong_password() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String s1 = alert.getText();
		String s2 = "Wrong password.";
		alert.accept();
		Assert.assertEquals(s2, s1,"Login failed");
	}

	@Then("the error message should be displayed as \"\"Please fill out Username and Password.\"\"")
	public void the_error_message_should_be_displayed_as_please_fill_out_Username_and_Password() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		String s1 = alert.getText();
		String s2 = "Please fill out Username and Password.";
		alert.accept();
		Assert.assertEquals(s2, s1,"Login failed");
	}

}
