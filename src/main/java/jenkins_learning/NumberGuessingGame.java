package jenkins_learning;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Add final to the class declaration (Fix 1)
public final class NumberGuessingGame {

    // Move field declarations to the top (Fix 2)
    // Use SLF4j Logger
    private static final Logger log = LoggerFactory.getLogger(NumberGuessingGame.class);
    // Create Random as a static final field for reuse
    private static final Random random = new Random();

    // Constructor now comes AFTER fields
    private NumberGuessingGame() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Method follows constructor
    public static void main(final String[] args) {

        final int target = random.nextInt(100) + 1;
        int attempts = 0;
        final int maxAttempts = 7;

        log.info("🎲 Welcome to Auto Guess the Number Game!");
        log.info("It will be fun!");
        log.info("I'm thinking of a number between 1 and 100.");
        log.info("You have {} attempts. Good luck!", maxAttempts);

        while (attempts < maxAttempts) {
            final int guess = random.nextInt(100) + 1;
            log.info("🤖 Attempt #{}: Guessing {}", attempts + 1, guess);

            attempts++;

            if (guess == target) {
                log.info("🎉 Robot guessed it in {} tries! Number was: {}", attempts, target);
                break;
            } else if (guess < target) {
                log.info("📉 Too low!");
            } else {
                log.info("📈 Too high!");
            }

            if (attempts == maxAttempts) {
                log.info("❌ Out of attempts! The number was: {}", target);
            }
        }
    }
}