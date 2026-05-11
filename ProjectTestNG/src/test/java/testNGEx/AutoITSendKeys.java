package testNGEx;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITSendKeys {

	public static void main(String[] args) throws IOException,InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/upload-download");
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id=\"uploadFile\"]"));
		fileUpload.sendKeys("C:\\Users\\Reshma\\Desktop\\RESHMA\\DataStructures_LinkedList.txt");
		String message = driver.findElement(By.id("Uploaded file path")).getText();
		System.out.println(message);
		driver.close();
		
		

	}

}