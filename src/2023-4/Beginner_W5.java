public class Beginner_W5 {
    public static void main(String[] args) {
        // To test out a method, write the method name and pass in the required
        // parameters!
        // For example, to test out the findNthWord method, write:
        // This line will print out "program"
        System.out.println(findNthWord("I can program in Java", 3));
    }

    /*
     * 1. Find the word: Write a program that accepts a String sentence and an
     * integer n as inputs, and returns the nth word from the string. For example,
     * for the string "I can program in Java" and n = 3, the output should be the
     * third word, "program"
     */
    public static String findNthWord(String sentence, int n) {
        String[] words = sentence.split(" ");
        return words[n - 1];
    }

    /*
     * 2. Word search: Write a program that accepts a string and a word as inputs,
     * and returns true if the string starts with the given word. For example, for
     * an input string of "hello world" and input word "hello," the program should
     * return true
     */
    public static boolean containsWord(String sentence, String word) {
        String[] wordChars = word.split("");
        String[] sentenceChars = sentence.split("");

        for (int i = 0; i < wordChars.length; i++) {
            if (!wordChars[i].equals(sentenceChars[i])) {
                return false;
            }
        }

        return true;
    }

    /*
     * 3. Anagrams: Write a program that accepts two strings as inputs and returns
     * true if they are anagrams of each other. For example, "tar" and "rat" are
     * anagram
     */
    public static boolean isAnagram(String word1, String word2) {
        String[] word1Chars = word1.split("");
        String[] word2Chars = word2.split("");

        if (word1Chars.length != word2Chars.length) {
            return false;
        }

        for (int i = 0; i < word1Chars.length; i++) {
            if (!word1Chars[i].equals(word2Chars[word1Chars.length - 1 - i])) {
                return false;
            }
        }

        return true;
    }

    /*
     * 4. Smallest number: Write a method that finds the smallest number among three
     * numbers.
     */
    public static int smallestNumber(int num1, int num2, int num3) {
        int smallest = num1;

        if (num2 < smallest) {
            smallest = num2;
        }

        if (num3 < smallest) {
            smallest = num3;
        }

        return smallest;
    }

    /*
     * 5. Average of numbers: Write a method that calculates the average of three
     * numbers
     */
    public static double averageOfNumbers(int num1, int num2, int num3) {
        return (num1 + num2 + num3) / 3.0;
    }

    /*
     * 6. Middle character: Write a method that displays the middle character of a
     * string
     */
    public static String middleCharacter(String word) {
        String[] wordChars = word.split("");
        int middleIndex = wordChars.length / 2;

        if (wordChars.length % 2 == 0) {
            return wordChars[middleIndex - 1] + wordChars[middleIndex];
        } else {
            return wordChars[middleIndex];
        }
    }

    /* 7. Count vowels: Write a method that counts all vowels in a string */
    public static int countVowels(String word) {
        String[] wordChars = word.split("");
        String[] vowels = { "a", "e", "i", "o", "u" };
        int vowelCount = 0;

        for (int i = 0; i < wordChars.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (wordChars[i].equals(vowels[j])) {
                    vowelCount++;
                    break;
                }
            }
        }

        return vowelCount;
    }

    /*
     * 8. Count words: Write a method that counts all the words in a string
     */
    public static int countWords(String sentence) {
        String[] words = sentence.split(" ");
        return words.length;
    }

    /*
     * 9. Sum of digits: Write a method that computes the sum of digits in an
     * integer
     */
    public static int sumOfDigits(int num) {
        String numString = String.valueOf(num);
        String[] numChars = numString.split("");
        int sum = 0;

        for (int i = 0; i < numChars.length; i++) {
            sum += Integer.parseInt(numChars[i]);
        }

        return sum;
    }

    /*
     * 10. Check even digits: Write a method that checks whether every digit of a
     * given integer is even. Return true if every digit is even, otherwise false
     */
    public static boolean checkEvenDigits(int num) {
        String numString = String.valueOf(num);
        String[] numChars = numString.split("");

        for (int i = 0; i < numChars.length; i++) {
            if (Integer.parseInt(numChars[i]) % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}