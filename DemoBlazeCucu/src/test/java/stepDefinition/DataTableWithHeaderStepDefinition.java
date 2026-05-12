package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DataTableWithHeaderStepDefinition {

    WebDriver driver;

    @Given("the user is on the home page and the user click the login link")
    public void the_user_is_on_the_home_page_and_the_user_click_the_login_link() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("user enter invalid data and login will unsuccessfull")
    public void user_enter_invalid_data_and_login_will_unsuccessfull(DataTable dataTable) {

        System.out.println("Enter Credentials");

        List<Map<String,String>> userTable = dataTable.asMaps(String.class, String.class);

        for(Map<String,String> form : userTable)
        {
            String userName = form.get("username");
            System.out.println("Username: " + userName);

            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys(userName);

            String password = form.get("password");
            System.out.println("Password: " + password);

            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys(password);

            driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).click();

            String expectedErrorMessage = form.get("errormsg");

            String actualErrorMessage = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText();

            System.out.println("Actual Error Message: "+ actualErrorMessage);

            Assert.assertTrue(actualErrorMessage.equalsIgnoreCase(expectedErrorMessage));
        }
    }
}