# Here are some guides for reading/writing CSV files in Java

## What is a CSV file?

CSV stands for Comma Separated Values. It is a file format that is used to store tabular data. Each line in a CSV file represents a row, and each column of data is separated by a comma.

CSV files are often used to store data that can be easily imported into a spreadsheet program like Microsoft Excel or Google Sheets. By convention, the first row of a CSV file is used to store the names of each column. All CSV files end with the extension .csv.

## How to read a CSV file in Java

First, we need to have an existing .csv file, and we need to know the path to that file. With these, we can use the following code to read the file:

```java
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
```

This code will read the file line by line, and split each line by the comma character. It will then return an ArrayList of String arrays, where each String array represents a row in the CSV file. This allows us to easily access and manipulate the data in the CSV file.

## Step-by-step guide

First, we need to create a BufferedReader object, which allows us to read a file line-by-line. The BufferedReader constructor takes in a FileReader object, which takes in the path to the file we want to read. To access these classes, we need to import the following packages:

```java
import java.io.BufferedReader;
import java.io.FileReader;
```

Then, to create a BufferedReader object, we can use the following code:

```java
String filePath = "example/path/to/file.csv";
BufferedReader reader = new BufferedReader(new FileReader(filePath));
```

Next, we need to create an ArrayList to store the data from the CSV file. In these version, we are representing each row of the table as a String array, and each column as an index of that array. We can do this by adding the following code:

```java
ArrayList<String[]> table = new ArrayList<String[]>();
```

Then, we need to read the file line-by-line. We can do this by using a while loop, and the readLine() method of the BufferedReader class. The readLine() method will return null when there are no more lines to read. We can use this to check if we have reached the end of the file. We can do this by adding the following code:

```java
String line = "";
while ((line = reader.readLine()) != null) {
    table.add(line.split(","));
}
```

The `.split()` method is a method in the String class. It takes in a String as a parameter, and splits the String into an array of Strings, using the parameter as a delimiter. In this case, we are using the comma character as the delimiter, so each column of the CSV file will be stored as an index of the String array.

For example, if we have a row in the CSV file that looks like this:

```
1,2,3,4,5
```

Then the String array will look like this:

```
["1", "2", "3", "4", "5"]
```

Finally, we need to close the BufferedReader object and return our table. We can do this by adding the following code:

```java
reader.close();

return table;
```

But what's the point of that try-catch thing surrounding the entire method? Well, the FileReader constructor and the readLine() method both throw an IOException, which is a child class of Exception. This means that if we don't surround the code with a try-catch block, the program will not compile. The try-catch block allows us to catch the IOException and print the Error stack trace, which is a list of all the methods that were called before the exception was thrown. This allows us to see where the error occurred, and fix it.

```java
try {
    // Code that might throw an exception
} catch (Exception e) {
    // Code that will run if an exception is thrown
}
```

You can also have multiple catch blocks which catch specific exceptions. This allows you to handle different exceptions differently. The `Exception` class is the parent class of all exceptions.

## How to write a CSV file in Java

But what's the point of reading and modifying a CSV file if we can't save our changes? Well, we can use the following code to write a CSV file:

```java
public static void writeCSVFile(String[] newRow, String filePath) {
    try {
        ArrayList<String[]> table = readCSVFile(filePath);
        table.add(newRow);

        FileWriter file = new FileWriter(filePath);

        for (String[] row : table) {
            file.write(String.join(",", row) + "\n");
        }

        file.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

This code will read the CSV file, add a new row to the end of the file, and then write the new table to the file. This allows us to easily save our changes to the CSV file.

## Step-by-step guide

First, we need to create an ArrayList to store the data from the CSV file. We can do this by adding the following code, taking advantage of the `readCSVFile()` method we created earlier:

```java
ArrayList<String[]> table = readCSVFile(filePath);
```

Then, we need to add a new row to the end of the table. We can do this by using the `.add()` method of the ArrayList class. We can do this by adding the following code:

```java
table.add(newRow);
```

Note that currently, we are not checking if the new row has the same number of columns as the rest of the table. This means that if the new row has a different number of columns, the CSV file will be invalid. Try to fix this yourself!

Next, we need to create a FileWriter object, which allows us to write to a file. The FileWriter constructor takes in a String as a parameter, which is the path to the file we want to write to. To access this class, we need to import the `java.io.FileWriter` library:

```java
import java.io.FileWriter;
```

Then, to create a FileWriter object, we can use the following code:

```java
FileWriter file = new FileWriter(filePath);
```

Then, we need to write the table to the file. We can do this by using a for-each loop, and the `.write()` method of the FileWriter class. The `.write()` method takes in a String as a parameter, and writes that String to the file. We can do this by adding the following code:

```java
for (String[] row : table) {
    file.write(String.join(",", row) + "\n");
}
```

The `String.join()` method is a static method in the `String` class. It takes in a String as a delimiter, and an array of Strings. It then joins all the Strings in the array together, using the delimiter. In this case, we are using the comma character as the delimiter, so each column of the CSV file will be separated by a comma. We are also adding a newline character `\n` at the end of each row, so that each row is on a new line.

For example, if we have a row in our CSV array that looks like this:

```
["1", "2", "3", "4", "5"]
```

Then the String created by `String.join(",", array)` will look like this:

```
"1,2,3,4,5"
```

Finally, we need to close the FileWriter object. We can do this by adding the following code:

```java
file.close();
```

We are again using a try-catch block to catch any IOExceptions that might be thrown by the FileWriter constructor or the `.write()` method.

## Closing thoughts

This is a very simple way to read and write CSV files in Java. However, If you want to learn more about reading and writing CSV files in Java, you can check out the following resources:

1. https://www.javatpoint.com/how-to-read-csv-file-in-java
2. https://www.baeldung.com/java-csv
3. https://howtodoinjava.com/java/library/parse-read-write-csv-opencsv/

Note that these resources use a different method to read and write CSV files. Instead of using a String array to represent each row, they use a custom class. This allows you to access each column by name, instead of by index. This is a much better way to read and write CSV files, but it is also more complicated.

They also mention using package managers like Maven and Gradle, which are tools that allow you to easily manage your dependencies. This is a very useful tool, but it is also very complicated, so we will not be covering it in this guide. Instead, you can download the library jars and add them to your project manually, just by searching for the library name on Google.
