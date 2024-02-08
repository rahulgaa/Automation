package JavaPackage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;
import java.util.LinkedHashSet;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;


public class RemoveDuplicates {

	public static void main(String[] args) throws IOException, InterruptedException {
		String name = "Final_Spanish_database_17k_out__eng";
//		String filepath = "C:\\Automation\\"+ name +".txt"; //C:\Users\shyam\Downloads\1L_english_words\input
		String filepath = "C:\\Users\\shyam\\Downloads\\1L_english_words\\input\\" + name +".txt";
		File file = new File(filepath);
		String fileName = file.getName();
//		System.out.println(fileName); // print file name with index
		// Remove the file extension if it exists
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0) {
            fileName = fileName.substring(0, dotIndex);
        }
        // get file name length
        int leng = fileName.length();
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
		
        LinkedHashSet<String> uniqueSet = new LinkedHashSet<>(arrayList);
        arrayList.clear();  // Clear the original ArrayList
        arrayList.addAll(uniqueSet); 
        
//        String savepath = ("C:\\Automation\\Vocab_Final\\" + name + '_' + leng+"_UniqueWords.txt" );//C:\Users\shyam\Downloads\1L_english_words\output
        String savepath = ("C:\\Users\\shyam\\Downloads\\1L_english_words\\output" + name + '_' + leng+"_UniqueWords.txt" );
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(savepath));
            for (String element : arrayList) {
                writer.write(element.toUpperCase());
                writer.newLine(); // Add a new line after each element
            }
            writer.close();
            System.out.println("ArrayList elements saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file.");
        }
        
//		
//        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://dictionary.cambridge.org/dictionary/spanish-english/");
//		driver.manage().window().maximize();
//		String word = fileName;
//		driver.findElement(By.xpath("//input[@id='searchword']")).click();
//		 for (String item : arrayList) {
//			 item =item.trim();
//			 System.out.println(item);
//			 driver.findElement(By.xpath("//input[@id='searchword']")).clear();
//			 driver.findElement(By.xpath("//input[@id='searchword']")).sendKeys(item);
//				Thread.sleep(2000);
//				List<WebElement> list= driver.findElements(By.xpath("//*[@id=\"resultAutoComplete\"]/a/span"));
//				for (WebElement e: list) {
//					if (e.getText().equalsIgnoreCase(item)) {
//					String lastWord = (e.getText());
//					System.out.println(lastWord);
//					String savepath = ("C:\\Automation\\Vocab_Final\\" + word + '_' + leng+"_Span.txt" );
//					FileWriter fr = new FileWriter(savepath, true);
//					BufferedWriter br = new BufferedWriter(fr);
//					br.newLine();
//					br.write(item);
//					br.close();
//					fr.close();
//					
//					Thread.sleep(1000);
//					System.out.println(item);
//					}
//					
//				}
//	            
//	        }

       System.out.println("Done");
	}
}