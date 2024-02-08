package JavaPackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
public class BrowserSelectorHub {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Automation Testing Software\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("rahulnamdeogaikwad@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("sweety@aditya");
		driver.findElement(By.name("login")).click();
		

	}

}
