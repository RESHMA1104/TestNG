package testNGEx;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClass {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://pdf2doc.com/");

        WebElement file = driver.findElement(By.xpath("//span[normalize-space()='UPLOAD FILES']"));

        file.click();

        Thread.sleep(3000);

        // Copy File Path
        StringSelection str = new StringSelection("C:\\Users\\Reshma\\Downloads\\Final report.pdf");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // Robot Class
        Robot rb = new Robot();

        // CTRL + V
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        // Wait
        Thread.sleep(2000);

        // Press ENTER
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File Uploaded Successfully");
        
    }
}