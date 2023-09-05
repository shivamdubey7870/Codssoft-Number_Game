import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int roundsWon = 0;
        
        while (true) {
            System.out.println("===== Number Guessing Game =====");
            boolean roundResult = playRound(lowerLimit, upperLimit, maxAttempts, random, scanner);
            if (roundResult) {
                roundsWon++;
            }
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                printGameSummary(rounds, roundsWon);
                break;
            }
        }

        scanner.close();
    }

    public static boolean playRound(int lowerLimit, int upperLimit, int maxAttempts, Random random, Scanner scanner) {
        int numberToGuess = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                return true;
            }
        }

        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
        return false;
    }
    
    public static void printGameSummary(int rounds, int roundsWon) {
        System.out.println("Thanks for playing!");
        System.out.println("You won " + roundsWon + " out of " + rounds + " rounds.");
    }
}
