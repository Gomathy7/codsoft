import java.util.Random;
import java.util.Scanner;
public class Number_Game {
    
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Create a Random object to generate random numbers
        Random rand = new Random();
        // Flag to control the game loop
        boolean PlayAgain = true;

        // Main game loop, continues until the user decides to stop
        while (PlayAgain) {
            // Generate a random number between 1 and 100
            int NumberToGuess = rand.nextInt(100) + 1;
            // Counter to track the number of attempts
            int Attempts = 0;
            // Maximum number of allowed attempts
            int MaxAttempts = 10;
            // Flag to check if the number has been guessed correctly
            boolean GuessedCorrectly = false;

            // Inform the user about the range and number of attempts
            System.out.println("Guess the number between 1 and 100. You have " + MaxAttempts + " attempts.");

            // Loop to handle the guessing process
            while (Attempts < MaxAttempts && !GuessedCorrectly) {
                // Prompt the user for a guess
                System.out.print("Enter your guess: ");

                // Input validation to ensure the user enters an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next(); // Consume the invalid input
                    System.out.print("Enter your guess: ");
                }

                int UserGuess = scanner.nextInt();
                // Increment the attempt counter
                Attempts++;

                // Check if the guess is too low
                if (UserGuess < NumberToGuess) {
                    System.out.println("Too low! Try again. You have " + (MaxAttempts - Attempts) + " attempts left.");
                } 
                // Check if the guess is too high
                else if (UserGuess > NumberToGuess) {
                    System.out.println("Too high! Try again. You have " + (MaxAttempts - Attempts) + " attempts left.");
                } 
                // If the guess is correct
                else {
                    System.out.println("Congratulations! You guessed the number in " + Attempts + " attempts.");
                    GuessedCorrectly = true;
                }
            }

            // If the user fails to guess the number within the allowed attempts
            if (!GuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + NumberToGuess);
            }

            // Ask the user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String UserResponse = scanner.next();

            // Input validation for play again response
            while (!UserResponse.equalsIgnoreCase("yes") && !UserResponse.equalsIgnoreCase("no")) {
                System.out.print("Invalid input! Please enter 'yes' or 'no': ");
                UserResponse = scanner.next();
            }

            // Update the playAgain flag based on user input
            PlayAgain = UserResponse.equalsIgnoreCase("yes");
        }

        // Close the scanner object
        scanner.close();
        // Thank the user for playing
        System.out.println("Thank you for playing!");
    }
}


