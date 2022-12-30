package week4day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

		public static void main(String[] args) throws InterruptedException {

			ChromeDriver driver = new ChromeDriver();

			driver.get("https://www.leafground.com/window.xhtml");
			driver.manage().window().maximize();

			driver.findElement(By.xpath("//span[text()='Open']//parent::button")).click();

			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windows = new ArrayList<String>(windowHandles);
			driver.switchTo().window(windows.get(1));
			Thread.sleep(2000);
			driver.close();
			
			driver.switchTo().window(windows.get(0));
			Set<String> windowHandles1 = driver.getWindowHandles();
			List<String> windows1 = new ArrayList<String>(windowHandles1);
			driver.findElement(By.xpath("//span[text()='Close Windows']//parent::button")).click();
			int size = windows1.size() - 1;
			
			while (size > 0) {
				driver.switchTo().window(windows1.get(size));
				driver.close();
				size--;
			}

			driver.findElement(By.xpath("//span[text()='Open Multiple']//parent::button")).click();
		    System.out.println(windows1.size());
			Thread.sleep(2000);
			driver.switchTo().window(windows1.get(0));
			
	        driver.quit();

		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

