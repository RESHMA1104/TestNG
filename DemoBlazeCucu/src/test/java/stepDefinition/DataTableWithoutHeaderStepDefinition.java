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

public class DataTableWithoutHeaderStepDefinition {
	WebDriver driver;
	
	@Given("the user is launch the application")
	public void the_user_is_launch_the_application() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("the user clicks on the login link")
	public void the_user_clicks_on_the_login_link() {
		driver.findElement(By.id("login2")).click();
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		System.out.println("Credentials Entered");
		List<List<String>> login = dataTable.asLists(String.class);
		String username = login.get(0).get(0);
		String password = login.get(0).get(1);
		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		
	}

	@When("the user clicks on the login button once credentials are entered")
	public void the_user_clicks_on_the_login_button_once_credentials_are_entered() {
		driver.findElement(By.xpath("//button[@onclick=\"logIn()\"]")).click();
	}

	@Then("the user should receives the message as logged in Successfully")
	public void the_user_should_receives_the_message_as_logged_in_successfully() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	    String text = driver.findElement(By.id("nameofuser")).getText();
	    System.out.println("Actual text: " + text);
	    if (!text.contains("Welcome")) {
	        throw new AssertionError("Login failed - Welcome message not displayed");
	    }
	}
}
