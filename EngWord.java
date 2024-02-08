package JavaPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EngWord {

    private static WebElement findStableElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed

        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private static boolean isValidWord(String word) {
        // Add conditions to check if the word contains unwanted characters
        return !word.contains(" ") && !word.contains("-") && !word.contains("(") && !word.contains(")")
                && !word.contains(".") && !word.contains(",") && !word.contains("+") && !word.contains("!")
                && !word.contains("'");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String name = "Final_Spanish_database_17k";
        String filepath = "C:\\Users\\shyam\\Downloads\\1L_english_words\\input\\" + name + ".txt";
        File file = new File(filepath);
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0) {
            fileName = fileName.substring(0, dotIndex);
        }

        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", "C:\\Automation Testing Software\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dictionary.cambridge.org/dictionary/spanish-english/");
        
        try {
            Set<String> storedWords = new HashSet<>();
            int index = 0;
            for (String item : arrayList) {
                item = item.toUpperCase().trim();
                System.out.println( index + " - " + item);
                index ++;
                

                boolean isElementFound = false;
                int attempts = 0;

                while (!isElementFound && attempts < 3) {
                    try {
                        WebElement searchInput = findStableElement(driver, By.xpath("//input[@id='searchword']"));
                        searchInput.clear();
                        searchInput.sendKeys(item);

                        // Your code to interact with the elements goes here

                        isElementFound = true; // Set this to true if the interaction is successful

                    } catch (StaleElementReferenceException e) {
                        System.out.println("StaleElementReferenceException caught. Retrying...");
                        attempts++;
                    }
                }

                Thread.sleep(1000);

                List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"resultAutoComplete\"]/a/span"));
                for (WebElement e : list) {
                	try {
                        if (e.isDisplayed()) {
 //                           System.out.println("Element found. Getting text...");
                            String lastWord = e.getText().trim();
//                            System.out.println("Text retrieved: " + lastWord);
                            // Rest of your code...
                            if (isValidWord(lastWord) && lastWord.length() <= 9 && !storedWords.contains(lastWord)) {
                                String savepath = ("C:\\Users\\shyam\\Downloads\\1L_english_words\\output\\" + fileName + '_'
                                        + "out_" + "_eng.txt");
                                FileWriter fr = new FileWriter(savepath, true);
                                BufferedWriter br = new BufferedWriter(fr);
                                lastWord = lastWord.toUpperCase();
                                br.newLine();
                                br.write(lastWord);
                                br.close();
                                fr.close();
                                storedWords.add(lastWord);
                            }
                        }
                    } catch (StaleElementReferenceException ex) {
                        // Handle StaleElementReferenceException (possibly retry the operation)
                        System.out.println("StaleElementReferenceException caught. Retrying...");
                    }
                	
                    
                }
            }

        } finally {
            driver.quit();
        }

        System.out.println("Done");
    }
}
