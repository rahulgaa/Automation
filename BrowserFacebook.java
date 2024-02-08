package JavaPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFacebook {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver_win32\\chromedriver.exe");
		//Creating the web driver object
		WebDriver driver;
		//Instantiating driver object and launching web browser
		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com");
		//driver.findElement(By.xpath ("//input[@name='email']")).sendKeys("rahulnamdeogaikwad@gmail.com");
		driver.findElement(By.id("email")).sendKeys("rahulnamdeogaikwad@gmail.com");
		Thread.sleep(2000);
		driver.quit();
				
				

	}


}
