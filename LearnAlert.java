package week4day1;

	import java.time.Duration;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class LearnAlert {

		public static void main(String[] args) {
			
			ChromeDriver driver =new ChromeDriver();
			driver.get("https://www.leafground.com/alert.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//click on confirm dialog
			driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
			
			//switch to alert
			Alert alert=driver.switchTo().alert();
			//get the text
			String txt =alert.getText();
			System.out.println(txt);
			//dismiss the alert
			driver.switchTo().alert().dismiss();
			
			//click on sweet alert
			driver.findElement(By.xpath("(//span[text()='Delete'])")).click();
		    // dismiss the sweet alert
			driver.findElement(By.xpath("(//span[text()='Yes'])")).click();
			
			
		}	
		}