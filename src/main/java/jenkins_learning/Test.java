package jenkins_learning;
import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int target = random.nextInt(100) + 1; // Random number between 1 and 100
	        int attempts = 0;
	        int maxAttempts = 7;

	        System.out.println("🎲 Welcome to Guess the Number Game!");
	        System.out.println("I'm thinking of a number between 1 and 100.");
	        System.out.println("You have " + maxAttempts + " attempts. Good luck!");

	        while (attempts < maxAttempts) {
	            System.out.print("Enter your guess: ");
	            int guess;

	            try {
	                guess = Integer.parseInt(scanner.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("⚠️ Please enter a valid number!");
	                continue;
	            }

	            attempts++;

	            if (guess == target) {
	                System.out.println("🎉 Congratulations! You guessed it in " + attempts + " tries!");
	                break;
	            } else if (guess < target) {
	                System.out.println("📉 Too low!");
	            } else {
	                System.out.println("📈 Too high!");
	            }

	            if (attempts == maxAttempts) {
	                System.out.println("❌ Out of attempts! The number was: " + target);
	            }
	        }

	}

}
