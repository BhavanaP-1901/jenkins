package jenkins_learning;
import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	  int maxAttempts = 7;
        int target = new Random().nextInt(100) + 1;

        System.out.println("🎲 Welcome to Guess the Number Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts. Good luck!");

        if (args.length == 0) {
            System.out.println("⚠️ No guess provided. Please pass a number as a command-line argument.");
            return;
        }

        try {
            int guess = Integer.parseInt(args[0]);

            if (guess == target) {
                System.out.println("🎉 Congratulations! You guessed it right!");
            } else if (guess < target) {
                System.out.println("📉 Too low! The number was: " + target);
            } else {
                System.out.println("📈 Too high! The number was: " + target);
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Invalid input. Please provide a numeric guess.");
        }
    }
	
	

}
