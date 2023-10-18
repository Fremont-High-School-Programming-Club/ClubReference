package Year20234.ExternalLibraries.CSVFileGuides;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CSVFile {
    public static void main(String[] args) {
        // This guide will show you how to read and write to a CSV file using only
        // built-in Java libraries
        // The guide methods contain comments that explain what each line of code does
        // The normal methods do not contain comments, and are example methods that you
        // can use in your own projects. Feel free to copy and paste!
    }

    public void readCSVFileGuide() {
        // This is how you read a CSV file using only built-in Java libraries
        // Note: a try-catch block is necessary because the BufferedReader class can
        // throw an exception, so this will prevent the program from crashing when that
        // happens
        try {
            // First, create a BufferedReader object, passing in a FileReader object as a
            // parameter. Make sure to specify the file path to where you want to read the
            // file
            // BufferedReader is a class that allows you to read a file line by line,
            // making it perfect for reading CSV files, as they represent a table with each
            // row on a new line
            BufferedReader reader = new BufferedReader(new FileReader("src/Year20234/ExternalLibraries/CSVFileGuides/data.csv"));

            // This arraylist will hold all the rows in the CSV file,
            // where each row is an array of strings
            ArrayList<String[]> table = new ArrayList<String[]>();

            // This while loop will read each line of the CSV file
            // The split method is a method that all strings have, and it splits the string
            // into an array of strings, using the parameter as the delimiter
            // For example, "hello,world".split(",") would return ["hello", "world"]
            // Finally, close the reader. It's good practice because it frees up memory
            String line = "";
            while ((line = reader.readLine()) != null) {
                table.add(line.split(","));
            }
            reader.close();

            // Now, you can access the data values from the table!
            for (String[] row : table) {
                for (String col : row) {
                    System.out.print(col + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            // This will print the error message if an exception is thrown
            // This is useful for debugging, but you can also just delete this line if you
            // don't want to see the error message
            // In this program, we specifically will get an error if the file does not
            // exist, called a FileNotFoundException
            e.printStackTrace();
        }
    }

    public static void writeCSVFileGuide() {
        // This is how you write to a CSV file using only built-in Java libraries
        // Note: a try-catch block is necessary because the FileWriter class can throw
        // an exception, so this will prevent the program from crashing when that
        // happens
        try {
            // I've created a 2D array of strings to represent the table
            // Each row is an array of strings, and the entire table is an array of rows
            // To shorten the code, I've initialized the array using a helper method at the
            // bottom of this file
            ArrayList<String[]> table = readCSVFile("src/Year20234/ExternalLibraries/CSVFileGuides/data.csv");

            // Now that we've read all the data from the CSV file, we can add a new row to
            // the table
            // Note: this is just an example, you can add whatever data you want,
            // but make sure that the data matches the format of the CSV file
            String[] newRow = { "John", "20", "2000-01-09", "2.0", "110" };
            table.add(newRow);

            // This is how you write to a CSV file
            // First, create a filewriter object and specify the file path to where you
            // want to write the file
            // Note: if the file does not exist, it will be created when you write the file
            // Note: if you don't specify a location to write to in the file, the contents
            // of the file will be overwritten
            FileWriter file = new FileWriter("src/Year20234/ExternalLibraries/CSVFileGuides/new_data.csv");

            // Then, write each row to the file
            // The join method is a method that all strings have, and it joins the array of
            // strings into a single string, using the parameter as the delimiter
            // For example, ["hello", "world"].join(",") would return "hello,world"
            // Note: the join method is static, so you have to call it from the String class
            // Note: \n just means a new line
            // Finally, close the filewriter. It's good practice because it frees up memory
            for (String[] row : table) {
                file.write(String.join(",", row) + "\n");
            }
            file.close();
        } catch (Exception e) {
            // This will print the error message if an exception is thrown
            // This is useful for debugging, but you can also just delete this line if you
            // don't want to see the error message
            // In this program, we specifically will get an error if the file does not
            // exist, called a FileNotFoundException
            e.printStackTrace();
        }
    }

    public static ArrayList<String[]> readCSVFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            ArrayList<String[]> table = new ArrayList<String[]>();

            String line = "";
            while ((line = reader.readLine()) != null) {
                table.add(line.split(","));
            }

            reader.close();

            return table;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeCSVFile(String[] newRow) {
        try {
            ArrayList<String[]> table = readCSVFile("src/Year20234/ExternalLibraries/CSVFileGuides/data.csv");
            table.add(newRow);

            FileWriter file = new FileWriter("src/Year20234/ExternalLibraries/CSVFileGuides/new_data.csv");

            for (String[] row : table) {
                file.write(String.join(",", row) + "\n");
            }

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}