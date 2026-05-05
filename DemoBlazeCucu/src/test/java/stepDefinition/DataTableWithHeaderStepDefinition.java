package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DataTableWithHeaderStepDefinition {
	WebDriver driver;
	@Given("the user is on the home page and the user click the login link")
	public void the_user_is_on_the_home_page_and_the_user_click_the_login_link() {
	}

	@Then("user enter invalid data and login will unsuccessfull")
	public void user_enter_invalid_data_and_login_will_unsuccessfull(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Enter Credentials");
		List<Map<String, String>> user userTable.asMaps(String.class; String lace for (Map<String, String> form: user) {

		String userName = form.get("Username"); System.out.println("Username:" + userName);

		driver.findElement(By.name("username")).sendKeys(userName);

		String password = form.get("Password");

		System.out.println("Password:" + password); driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).submit();

		String errorMessage = form.get("ErrorMessage");

		String actual ErrorMessage = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText(); System.out.println("Artual Error Message:" + actual ErrorMessage);

		Assert.assertTrue(actual ErrorMessage.equalsIgnoreCase(errorMessage)); }}
	}
}
