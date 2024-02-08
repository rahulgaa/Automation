package JavaPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SQLiteToTxtExporter {
    private static boolean isValidWord(String word) {
        return !word.contains(" ") && !word.contains("-") && !word.contains("(") && !word.contains(")") &&
               !word.contains(".") && !word.contains(",") && !word.contains("+") && !word.contains("!") &&
               !word.contains("'");
    }

    public static void main(String[] args) {
        String dbFilePath = "C:\\Unity Projects\\Input_spanish\\dictPic.db";
        String txtFilePath = "C:\\Unity Projects\\Output_spanish\\libdb.txt";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT displayWord FROM spaWordList");

            List<String> dataLines = new ArrayList<>();
            Set<String> storedWords = new HashSet<>();

            while (resultSet.next()) {
                String word = resultSet.getString("displayWord");
                if (isValidWord(word) && word.length() <= 9 && !storedWords.contains(word)) {
                    dataLines.add(word.toUpperCase());
                    storedWords.add(word);
                }
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

            // Convert List to String array
            String[] dataArray = dataLines.toArray(new String[0]);

            // Save the String array to a text file
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(txtFilePath))) {
                for (String line : dataArray) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                System.out.println("Data exported to " + txtFilePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SQLiteToTxtExporter {
//    private static boolean isValidWord(String word) {
//        return !word.contains(" ") && !word.contains("-") && !word.contains("(") && !word.contains(")") &&
//               !word.contains(".") && !word.contains(",") && !word.contains("+") && !word.contains("!") &&
//               !word.contains("'");
//    }
//
//    public static void main(String[] args) {
//        String dbFilePath = "C:\\Unity Projects\\Input_spanish\\dictPic.db";
//        String txtFilePath = "C:\\Unity Projects\\Output_spanish\\libdb.txt";
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT displayWord FROM spaWordList");
//
//            List<String> dataLines = new ArrayList<>();
//
//            while (resultSet.next()) {
//                String word = resultSet.getString("displayWord");
//                if (isValidWord(word)) {
//                    dataLines.add(word);
//                }
//            }
//
//            // Close resources
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//            // Convert List to String array
//            String[] dataArray = dataLines.toArray(new String[0]);
//
//            // Save the String array to a text file
//            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(txtFilePath))) {
//                for (String line : dataArray) {
//                    bufferedWriter.write(line);
//                    bufferedWriter.newLine();
//                }
//                System.out.println("Data exported to " + txtFilePath);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
