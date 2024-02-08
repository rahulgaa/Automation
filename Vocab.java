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

public class Vocab {

	public static void main(String[] args) throws InterruptedException, IOException {



		System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String word = "Colmy";
		word = word.toUpperCase();
		System.out.println(word); 
		driver.get("https://www.wordmine.info/spanish/scrabble-and-wordfeud-cheat/"+ word ); // search word on link
		driver.manage().window().maximize();
		List<WebElement> page = driver.findElements(By.className("pagenumbercurrent")); // Current page number in string
		int curPage =Integer.parseInt(page.get(0).getText()); // page number string to integer
		List<WebElement> allpage = driver.findElements(By.className("pagenumber")); // get all page numbers
		Object[] pageNum = allpage.toArray(); // convert webelement to arraylist
		int num = pageNum.length; // page num count
		int pageCount = (num /2) -1; // final count total available page
		System.out.println(pageCount);
		List<WebElement> vocab = driver.findElements(By.partialLinkText("Show more information about ")); //find words
		for (WebElement w : vocab) {
			String words = w.getText(); // get webelement list to text
			StringBuilder stringBuilder = new StringBuilder(words); // fetched list stored in string
			StringBuilder newWord = stringBuilder.delete(0, 27); // Removed unwanted text and final word sorted
			String filepath = ("C:\\Automation\\Store\\" + word + ".txt" );
			FileWriter fr = new FileWriter(filepath, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.newLine();
			br.write(newWord.toString());
			br.close();
			fr.close();
			}
		
		int nextPage = curPage + 1; 
		Thread.sleep(2000);
		for (int i = nextPage; i<=pageCount; i++) {
			System.out.println(i);
		driver.get("https://www.wordmine.info/spanish/scrabble-and-wordfeud-cheat/"+ word + "?pageno="+ i );
		page = driver.findElements(By.className("pagenumbercurrent"));
		curPage =Integer.parseInt(page.get(0).getText());
		System.out.println("current page number" + curPage);
		Thread.sleep(2000);
		vocab = driver.findElements(By.partialLinkText("Show more information about "));
		for (WebElement w : vocab) {
			String words = w.getText();

			StringBuilder stringBuilder = new StringBuilder(words); // fetched list stored in string
			StringBuilder newWord = stringBuilder.delete(0, 27); // Removed unwanted text and final word sorted

			String filepath = ("C:\\Automation\\Store\\" + word + ".txt" );
			FileWriter fr = new FileWriter(filepath, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.newLine();
			br.write(newWord.toString());
			br.close();
			fr.close();
			
			}
	}
		System.out.println("Done");;
} 
}
