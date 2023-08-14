/*
                         -----WORD COUNTER-----
1. Prompt the user to enter a text or provide a file to count the words.
2. Read the input text or file and store it in a string.
3. Split the string into an array of words using space or punctuation as delimiters.
4. Initialize a counter variable to keep track of the number of words.
5. Iterate through the array of words and increment the counter for each word encountered.
6. Display the total count of words to the user.

*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Count Program");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file path");
        System.out.print("Choose an option (1/2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String inputText = "";
        
        if (choice == 1) {
            System.out.print("Enter your text: ");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter file path: ");
            String filePath = scanner.nextLine();
            
            try {
                Scanner fileScanner = new Scanner(new File(filePath));
                while (fileScanner.hasNextLine()) {
                    inputText += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }
        
        String[] words = inputText.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);

        scanner.close();
    }
}
