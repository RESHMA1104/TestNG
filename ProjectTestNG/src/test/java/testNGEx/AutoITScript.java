package testNGEx;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITScript {

	public static void main(String[] args) throws IOException,InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://pdf2doc.com/");
		WebElement file=driver.findElement(By.xpath("//span[normalize-space()='UPLOAD FILES']"));
		file.click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\Reshma\\Desktop\\DemoAutoIT.exe");
		
	}

}