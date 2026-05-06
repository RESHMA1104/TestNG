package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginTutorialsStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on TutorialsNinja Home page")
    public void user_is_on_tutorials_ninja_home_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Given("User click on My Account Link")
    public void user_click_on_my_account_link() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
    }

    @Given("User click on Register button")
    public void user_click_on_register_button() {
        driver.findElement(By.linkText("Register")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
    }

    @When("User enters valid registration details")
    public void user_enters_valid_registration_details(DataTable dataTable) {

        List<List<String>> data = dataTable.asLists();

        String firstName = data.get(0).get(0);
        String lastName = data.get(0).get(1);
        String email = data.get(0).get(2);
        String phone = data.get(0).get(3);
        String password = data.get(0).get(4);
        String confirmPassword = data.get(0).get(5);

        // handle null/empty
        firstName = (firstName == null) ? "" : firstName;
        lastName = (lastName == null) ? "" : lastName;
        phone = (phone == null) ? "" : phone;

        email = "user" + System.currentTimeMillis() + "@test.com";

        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(phone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
    }

    @When("User selects privacy policy checkbox")
    public void user_selects_privacy_policy_checkbox() {
        driver.findElement(By.name("agree")).click();
    }

    @When("User clicks on continue button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    @Then("User account should be created successfully")
    public void user_account_should_be_created_successfully() {

        String successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))
        ).getText();

        if (!successMsg.contains("Your Account Has Been Created!")) {
            throw new AssertionError("Account creation failed");
        }

        driver.quit();
    }
}