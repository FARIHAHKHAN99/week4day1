package week4day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrame {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click Try It Button
		driver.switchTo().frame("iframeResult"); //str
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        
        //Click OK/Cancel in the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
       
        //Confirm the action is performed correctly by verifying the text !!
        WebElement verify = driver.findElement(By.xpath("//p[@id='demo']"));
        String txt= verify.getText();
       
       
	}
	}

