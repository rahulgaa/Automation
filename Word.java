package JavaPackage;
import java.util.List;
import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Word {


	public static void main(String[] args) throws InterruptedException, IOException {



				System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://dictionary.cambridge.org/dictionary/spanish-english/");
				driver.manage().window().maximize();
				String word = "AMO";
				driver.findElement(By.xpath("//input[@id='searchword']")).click();
				driver.findElement(By.xpath("//input[@id='searchword']")).sendKeys(word);
				Thread.sleep(2000);
				List<WebElement> list= driver.findElements(By.xpath("//*[@id=\"resultAutoComplete\"]/a/span"));
//				Thread.sleep(2000);
				for (WebElement e: list) {
					
					if (e.getText().equalsIgnoreCase(word)) {
					String lastWord = (e.getText());
					System.out.println(lastWord);
					String filepath = ("C:\\Automation\\Vocab_Final\\" + word + "_Span.txt" );
//					File file = new File("append.txt");
					FileWriter fr = new FileWriter(filepath, true);
					BufferedWriter br = new BufferedWriter(fr);
					br.newLine();
					br.write(word);
					br.close();
					fr.close();
					System.out.println(word.length()); 
					}
				}
				
				
			}




	}


