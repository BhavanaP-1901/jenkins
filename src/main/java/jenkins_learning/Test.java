package jenkins_learning;
import java.util.Random;

public class Test {

		      public static void main(String[] args) {
		          Random random = new Random();
		          int target = random.nextInt(100) + 1; // Random number between 1 and 100
		          int attempts = 0;
		          int maxAttempts = 7;

		          System.out.println("🎲 Welcome to Auto Guess the Number Game!");
		          System.out.println("I'm thinking of a number between 1 and 100.");
		          System.out.println("You have " + maxAttempts + " attempts. Good luck!");

		          while (attempts < maxAttempts) {
		              int guess = random.nextInt(100) + 1; // simulate a guess
		              System.out.println("🤖 Attempt #" + (attempts + 1) + ": Guessing " + guess);

		              attempts++;

		              if (guess == target) {
		                  System.out.println("🎉 Robot guessed it in " + attempts + " tries! Number was: " + target);
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

	

