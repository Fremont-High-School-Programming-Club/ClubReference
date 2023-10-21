# Guides for reading and writing JSON files

## What is a JSON File?

JSON stands for JavaScript Object Notation. It is a file format that is used to store data in a way that is easy for humans to read and write, and easy for computers to parse and generate. JSON files are often used to store data that can be easily imported into a JavaScript program. By convention, JSON files end with the extension .json.

However, JSON Files are not restricted to only JavaScript. They can be used in any programming language, and are often used to store complex, nested data that is easily readable by humans.

## How do JSON files store data?

JSON files store data in a key-value format. Each key-value pair is separated by a comma, and each key is separated from its value by a colon. The value can be a string, number, boolean, array, or another JSON object. JSON files can also contain comments, which are ignored by the parser.

Here is an example JSON file:

```json
{
  "name": "John Doe",
  "age": 30,
  "isMarried": false,
  "hobbies": ["reading", "writing", "coding"],
  "address": {
    "street": "123 Main St",
    "city": "New York",
    "state": "NY",
    "zip": "10001"
  }
}
```

In this file, we are representing a person's data. We can access the name of the person by using the key "name", and we can access the person's hobbies by using the key "hobbies". We can also access the person's address by using the key "address", and then accessing the street, city, state, and zip keys of the address object.

In java, we cannot directly create a JSON object. Instead, we need to use a library to parse the JSON file into a Java object. We will be using the [org.json](https://github.com/stleary/JSON-java) library for this guide. To use this library, simply download the jar file from the top of the README, and manually add it to your project's libraries.

## How to read a JSON file in Java

First, we need to have an existing .json file, and we need to know the path to that file. With these, we can use the following code to read the file:

```java
public static JSONObject readJSONFile(String filePath) {
    try {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(content);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
```

This code will read the file and return a JSONObject, which is a class from the org.json library. This allows us to easily access and manipulate the data in the JSON file. This code uses the following libraries:

```java
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
```

## But how do we code with JSON files?

Here is an example of some code which creates a JSONObject and then put values into that object:

```java
JSONObject person = new JSONObject();
person.put("name", "John Doe");
person.put("age", 30);
person.put("isMarried", false);

JSONArray hobbies = new JSONArray();
hobbies.put("reading");
hobbies.put("writing");
hobbies.put("coding");

person.put("hobbies", hobbies);

JSONObject address = new JSONObject();
address.put("street", "123 Main St");
address.put("city", "New York");
address.put("state", "NY");
address.put("zip", "10001");

person.put("address", address);
```

The `put()` method allows us to add key-value pairs to the JSONObject. It takes in two parameters: a String key, which signifies the name or category of the value, and an Object value, which is the value that we want to store. The value can be a String, Number, Boolean, JSONArray, or another JSONObject.

At the end of the above code, we have created the JSON object that we saw in the previous section. We can then write this object to a file using the following code:

```java
public static void writeJSONFile(String filePath, JSONObject object) {
    try {
        FileWriter writer = new FileWriter(filePath);
        writer.write(object.toString());
        writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

This code will write the JSONObject to the file. The `.toString()` method of the JSONObject class converts the JSONObject into a String, which can then be written to the file.

## How do we access values in a JSONObject?

We can access values in a JSONObject by using the `.get()` method. This method takes in a String key as a parameter, and returns the value associated with that key. For example, if we wanted to get the name of the person in the previous example, we could use the following code:

```java
String name = person.get("name");
```

We can also access values in nested JSONObjects. For example, if we wanted to get the city of the person's address, we could use the following code:

```java
String city = person.getJSONObject("address").get("city");
```

## How do we add/modify values in a JSONObject?

We can modify values in a JSONObject by using the `.put()` method. This method takes in a String key and an Object value as parameters, and sets the value associated with that key to the new value. For example, if we wanted to change the person's name to "Jane Doe" and add a gender field, we could use the following code:

```java
person.put("name", "Jane Doe");
person.put("gender", "female")
```

We can also modify values in nested JSONObjects. For example, if we wanted to change the person's city to "Los Angeles" and add a field for coast, we could use the following code:

```java
person.getJSONObject("address").put("city", "Los Angeles");
person.getJSONObject("address").put("coast", "west");
```

## How do we remove values in a JSONObject?

We can remove values in a JSONObject by using the `.remove()` method. This method takes in a String key as a parameter, and removes the value associated with that key. For example, if we wanted to remove the person's hobbies, we could use the following code:

```java
person.remove("hobbies");
```

We can also remove values in nested JSONObjects. For example, if we wanted to remove the person's state, we could use the following code:

```java
person.getJSONObject("address").remove("state");
```

## Takeways

JSON files are a great way to store data in a way that is easy for humans to read and write, and easy for computers to parse and generate. Whenever you need to store complicated data that needs to be quickly accessed, consider using a JSON file.
