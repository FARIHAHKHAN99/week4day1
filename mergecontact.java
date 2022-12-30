package week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mergecontact {

		public static void main(String[] args) throws InterruptedException {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notification");
			
			ChromeDriver driver = new ChromeDriver(options);

			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			// Enter UserName and Password Using Id Locator
			driver.findElement(By.id("username")).sendKeys("DemoCSR");
			driver.findElement(By.id("password")).sendKeys("crmsfa");

			// Click on Login Button using Class Locator
			driver.findElement(By.className("decorativeSubmit")).click();

			// Click on CRM/SFA Link
			driver.findElement(By.linkText("CRM/SFA")).click();

			// Click on contacts Button
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			// Click on Merge Contacts using Xpath Locator
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

			// Click on Widget of From Contact
			driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']/parent::a")).click();

			// Click on First Resulting Contact

			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windows = new ArrayList<String>(windowHandles);
			
			driver.switchTo().window(windows.get(1));
			System.out.println(windows.get(1));
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

			driver.switchTo().window(windows.get(0));

			// Click on Widget of To Contact
			driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif']/parent::a)[2]")).click();

			Set<String> windowHandles1 = driver.getWindowHandles();
			List<String> windows1 = new ArrayList<String>(windowHandles1);
			driver.switchTo().window(windows1.get(1));
			Thread.sleep(2000);

			// Click on Second Resulting Contact
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
			driver.switchTo().window(windows1.get(0));
			
			// Click on Merge button using Xpath Locator
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			Thread.sleep(2000);

			// Accept the Alert
			Alert alert = driver.switchTo().alert();
			alert.accept();

			// Verify the title of the page
			String title = driver.getTitle();
			System.out.println(title);

			driver.close();
		}

	}

