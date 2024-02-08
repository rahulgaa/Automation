package JavaPackage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;


public class InputList {
	
	private static WebElement findStableElement(WebDriver driver, By by) throws InterruptedException {
	    int maxAttempts = 3;
	    int attempt = 0;
	    WebElement element = null;

	    while (attempt < maxAttempts) {
	        try {
	            element = driver.findElement(by);
	            if (element.isDisplayed() && element.isEnabled()) {
	                return element;
	            }
	        } catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException caught. Retrying...");
	        }
	        
	        attempt++;
	        Thread.sleep(1000); // Pause for a moment before retrying
	    }

	    // If the element is not found even after retries, throw an exception
	    throw new StaleElementReferenceException("Failed to locate element after retries");
	}

//    private static WebElement findStableElement(WebDriver driver, By by) throws InterruptedException {
//        int maxAttempts = 3;
//        int attempt = 0;
//        WebElement element = null;
//
//        while (attempt < maxAttempts) {
//            try {
//                element = driver.findElement(by);
//                if (element.isDisplayed() && element.isEnabled()) {
//                    return element;
//                }
//            } catch (StaleElementReferenceException e) {
//                System.out.println("StaleElementReferenceException caught. Retrying...");
//            }
//        }
//            attempt++;
//            Thread.sleep(1000); // Pause for a moment before retrying
//			return element;
//        }

	public static void main(String[] args) throws IOException, InterruptedException {
		String name = "input";
		String filepath = "C:\\Users\\shyam\\Downloads\\1L_english_words\\input\\"+ name +".txt"; 
		File file = new File(filepath);
		String fileName = file.getName();
//		System.out.println(fileName); // print file name with index
		// Remove the file extension if it exists
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0) {
            fileName = fileName.substring(0, dotIndex);
        }
        // get file name length
//        int leng = fileName.length();
        // create array list to store element in array
        ArrayList<String> arrayList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader (new FileReader(filepath))){
			String line;
			while ((line= br.readLine()) != null) {
				arrayList.add(line);
			}
		}
        catch (IOException e) {
                e.printStackTrace();
        }
		
        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dictionary.cambridge.org/dictionary/english/");
//		driver.manage().window().maximize();
		String word = fileName;
		driver.findElement(By.xpath("//input[@id='searchword']")).click();
		Set<String> storedWords = new HashSet<>();
		 for (String item : arrayList) {
			 item = item.toUpperCase();
			 item =item.trim();
			 System.out.println(item);
	            boolean isElementFound = false;
	            int attempts = 0;
//			 driver.findElement(By.xpath("//input[@id='searchword']")).clear();
//			 driver.findElement(By.xpath("//input[@id='searchword']")).sendKeys(item);
	            while (!isElementFound && attempts < 3) {
	                try {
	                
//	                    WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchword']"));
	                	WebElement searchInput = findStableElement(driver, By.xpath("//input[@id='searchword']"));
	                    searchInput.clear();
	                    searchInput.sendKeys(item);
	                    
	                    // Rest of your code to interact with the elements
	                    
	                    isElementFound = true; // Set this to true if the interaction is successful
	                    
	                } catch (StaleElementReferenceException e) {
	                    System.out.println("StaleElementReferenceException caught. Retrying...");
	                    attempts++;
	                }
	            }
				Thread.sleep(1000);
				List<WebElement> list= driver.findElements(By.xpath("//*[@id=\"resultAutoComplete\"]/a/span"));
				for (WebElement e: list) {
//					if (e.getText().equalsIgnoreCase(item)) {
//				if (e.getText() != null) {
					String lastWord = e.getText().trim();
//					String lastWord = (e.getText());
//					System.out.println(lastWord);
					
					if (isValidWord(lastWord) && lastWord.length() <= 9 && !storedWords.contains(lastWord)) {
					String savepath = ("C:\\Users\\shyam\\Downloads\\1L_english_words\\output\\" + word + '_' + "out_"+"_eng.txt" );
					FileWriter fr = new FileWriter(savepath, true);
					BufferedWriter br = new BufferedWriter(fr);
					lastWord = lastWord.toUpperCase();
					br.newLine();
					br.write(lastWord);	
					br.close();
					fr.close();
					storedWords.add(lastWord);
//					Thread.sleep(1000);
//					System.out.println(lastWord);
					}
				}
	          }

       System.out.println("Done");
	}
//	}
	
	private static boolean isValidWord(String word) {
        // Add conditions to check if the word contains unwanted characters
        return !word.contains(" ") && !word.contains("-") && !word.contains("(") && !word.contains(")") && !word.contains(".") && !word.contains(",") && !word.contains("+") && !word.contains("!") && !word.contains("'");
    }
	
	
}