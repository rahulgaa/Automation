package JavaPackage;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenBrowser1 {
	public static void main(String[] args) throws InterruptedException {
		//Setting the property of Chrome Browser and path of driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //WebDriver is interface of Selenium & ChromeDriver is a Class of webdriver interface for chrome browser
		driver.get("https://www.facebook.com/"); //get is method to load new web pages
		driver.manage().window().maximize(); // manage is method to manage windows and maximize is performing operation on windows
		

		
		
	}

}
