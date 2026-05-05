package stepDefinition;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {
	WebDriver driver;
	
	@Given("the user is on the Home Page")
	public void the_user_is_on_the_home_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");
	}

	@When("the user clicks on login link")
	public void the_user_clicks_on_login_link() {
		driver.findElement(By.id("login2")).click();
	}

	@When("the user enters username as {string}")
	public void the_user_enters_username_as(String username) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
	    driver.findElement(By.id("loginusername")).sendKeys(username);
	}

	@When("the user enters password as {string}")
	public void the_user_enters_password_as(String password) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
	    driver.findElement(By.id("loginpassword")).sendKeys(password);
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//button[@onclick=\"logIn()\"]")).click();
	}

	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	    String text = driver.findElement(By.id("nameofuser")).getText();
	    System.out.println("Actual text: " + text);
	    if (!text.contains("Welcome")) {
	        throw new AssertionError("Login failed - Welcome message not displayed");
	    }
	}
}