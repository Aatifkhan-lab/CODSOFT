import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(MAX_RANGE) + 1;
            int attemptsLeft = MAX_ATTEMPTS;

            System.out.println("Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ". You have " + MAX_ATTEMPTS + " attempts.");

            boolean guessCorrect = false;
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = validateIntInput(scanner);

                if (userGuess == targetNumber) {
                    guessCorrect = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again!");
                } else {
                    System.out.println("Too high. Try again!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (guessCorrect) {
                score++;
                System.out.println("Congratulations! You guessed the number!");
            } else {
                System.out.println("Sorry! You ran out of attempts. The number was: " + targetNumber);
            }

            System.out.println("Your score: " + score);
            System.out.print("Play again? (yes/no): ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("yes");

            scanner.nextLine(); // Clear the buffer after reading the play again choice.
        }

        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }

    private static int validateIntInput(Scanner scanner) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < MIN_RANGE || value > MAX_RANGE) {
                    throw new NumberFormatException();
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer between " + MIN_RANGE + " and " + MAX_RANGE + ": ");
            }
        }
    }
}
