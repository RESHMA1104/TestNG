package stepDefinition;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableWithoutHeader1StepDefinition {
	WebDriver driver;
	@Given("user is launch the application")
	public void user_is_launch_the_application() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("the user clicks the login link")
	public void the_user_clicks_the_login_link() {
		driver.findElement(By.id("login2")).click();
	}

	@When("user enters the valid credentials")
	public void user_enters_the_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Credentials Entered");
		List<List<String>> login = dataTable.asLists(String.class);
		String username = login.get(0).get(0);
		String password = login.get(0).get(1);
		String username1 = login.get(1).get(0);
		String password1 = login.get(1).get(1);
		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.id("loginusername")).sendKeys(username1);
		driver.findElement(By.id("loginpassword")).sendKeys(password1);
	}

	@When("the user clicks on the login button when credentials are entered")
	public void the_user_clicks_on_the_login_button_when_credentials_are_entered() {
		driver.findElement(By.xpath("//button[@onclick=\"logIn()\"]")).click();
	}

	@Then("the user should see as logged in Successfully")
	public void the_user_should_see_as_logged_in_successfully() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	    String text = driver.findElement(By.id("nameofuser")).getText();
	    System.out.println("Actual text: " + text);
	    if (!text.contains("Welcome")) {
	        throw new AssertionError("Login failed - Welcome message not displayed");
	    }
	}
}
