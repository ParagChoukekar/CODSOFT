/*
                -----NUMBER GAME-----
1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and provide feedback on whether the guess
   is correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.

*/
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have generated a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You've guessed the correct number: " + generatedNumber);
            } else if (userGuess < generatedNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        } while (userGuess != generatedNumber);

        scanner.close();
    }
}
