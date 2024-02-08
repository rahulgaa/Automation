package JavaPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class RemoveInvalidWord {

    private static boolean isValidWord(String word) {
        // Define a regular expression for allowed characters
        String allowedCharactersRegex = "[a-zA-Z]+"; // Only alphabets are allowed
        // Check if the word matches the regular expression
        return word.matches(allowedCharactersRegex);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String name = "Final_Spanish_database_17k_out__eng";
        String filepath = "C:\\Users\\shyam\\Downloads\\1L_english_words\\input\\" + name + ".txt";
        File file = new File(filepath);
        String fileName = file.getName();

        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > 0) {
            fileName = fileName.substring(0, dotIndex);
        }

        int leng = fileName.length();
        ArrayList<String> arrayList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the word is valid before adding it to the ArrayList
                if (isValidWord(line)) {
                    arrayList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashSet<String> uniqueSet = new LinkedHashSet<>(arrayList);
        arrayList.clear();
        arrayList.addAll(uniqueSet);

        String savepath = "C:\\Users\\shyam\\Downloads\\1L_english_words\\output" + name + '_' + leng + "_UniqueWords.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(savepath));
            for (String element : arrayList) {
                writer.write(element.toUpperCase());
                writer.newLine();
            }
            writer.close();
            System.out.println("ArrayList elements saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to file.");
        }

        System.out.println("Done");
    }
}
