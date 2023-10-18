package Year20234.ExternalLibraries.JSONFileGuides;

// The org file is the external library that we are using
// Download it from https://github.com/stleary/JSON-java
// The download link is at the top of the README.md, under the picture
import org.json.JSONObject;

// These libraries come with Java, no download necessary!
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONFile {
    public static void main(String[] args) {
        // This is how you create a JSON object and give it data values
        JSONObject obj = new JSONObject();

        // First param is the key, second param is the value
        // The key must be a String
        // The value can be a String, int, double, boolean, or another JSON object
        obj.put("name", "foo");
        obj.put("num", 100);
        obj.put("balance", 1000.21);

        JSONObject innerObj = new JSONObject();
        innerObj.put("start", "04/04/1984");
        innerObj.put("end", "06/06/2006");

        obj.put("times", innerObj);
        obj.put("is_vip", true);

        // This try-catch block is necessary because the FileWriter class can throw an
        // exception
        // If you don't know what exceptions are, don't worry about it for now
        // Just remember to always wrap reading & writing files in this try-catch block
        try {
            // This is how you write the JSON object to a file
            // First, create a filewriter object and specify the file path to where you
            // want to write the file
            // Note: if the file does not exist, it will be created when you write the file
            // Note: if the file already exists, it will be overwritten when you write the
            // new file, as opposed to appending to the file
            FileWriter file = new FileWriter("src/Year20234/ExternalLibraries/JSONFileGuides/data.json");
            // Then, write the JSON object string to the file
            file.write(obj.toString());
            // Finally, close the filewriter to save the changes you made
            file.close();

            // This is how you read the JSON object from a file
            // First, read the file into a string by getting the bytes from the file and
            // creating a new string object from those bytes
            String content = new String(Files.readAllBytes(Paths.get("src/Year20234/ExternalLibraries/JSONFileGuides/data.json")));

            // Then, create a new JSON object from the string
            JSONObject obj2 = new JSONObject(content);

            // Now, you can access the data values from the JSON object!
            System.out.println(obj2);
            System.out.println("The user " + obj2.get("name") + " has a num of " + obj2.get("num") + " with a balance of " + obj2.get("balance")
                    + " and it is " + obj2.get("is_vip") + " that they are a VIP");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
