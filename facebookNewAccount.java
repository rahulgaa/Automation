package JavaPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookNewAccount {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
//		String Butt = driver.findElement(By.xpath("//a[@data-testid ='open-registration-form-button']")).getText();
//		System.out.println(Butt);
//		System.out.println(driver.findElement(By.xpath("//a[@data-testid ='open-registration-form-button']")).getTagName());
//		driver.findElement(By.xpath("//a[@data-testid ='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//a[text() = 'Create new account']")).click();
		Thread.sleep(2000);
		List <WebElement> radios = driver.findElements(By.xpath("//input[@type = 'radio']"));
		System.out.println(radios.size());
	}

}
