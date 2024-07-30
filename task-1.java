import java.util.*;

public class EnhancedEnigma {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int TRIES_ALLOWED = 5;
    private static final int ROUNDS_TOTAL = 3;

    private final Scanner input;
    private final Random rand;

    public EnhancedEnigma() {
        this.input = new Scanner(System.in);
        this.rand = new Random();
    }

    public void playGame() {
        int wins = 0;
        for (int round = 1; round <= ROUNDS_TOTAL; round++) {
            System.out.println("\nRound: " + round);
            if (playRound()) {
                wins++;
            }
        }
        displayFinalScore(wins);
    }

    private boolean playRound() {
        int target = generateTarget();
        System.out.printf("Guess a number between %d and %d. You have %d tries.%n", MIN, MAX, TRIES_ALLOWED);

        for (int attempt = 1; attempt <= TRIES_ALLOWED; attempt++) {
            int guess = getValidGuess();
            if (evaluateGuess(guess, target, attempt)) {
                return true;
            }
        }

        System.out.println("Sorry, you ran out of tries. The number was: " + target);
        return false;
    }

    private int generateTarget() {
        return rand.nextInt(MAX - MIN + 1) + MIN;
    }

    private int getValidGuess() {
        while (true) {
            System.out.print("Enter your guess: ");
            try {
                int guess = Integer.parseInt(input.nextLine());
                if (guess >= MIN && guess <= MAX) {
                    return guess;
                } else {
                    System.out.printf("Please enter a number between %d and %d.%n", MIN, MAX);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private boolean evaluateGuess(int guess, int target, int attempt) {
        if (guess == target) {
            System.out.println("Correct! You guessed it in " + attempt + " tries.");
            return true;
        } else {
            System.out.println(guess < target ? "Too low." : "Too high.");
            return false;
        }
    }

    private void displayFinalScore(int wins) {
        System.out.printf("%nGame over! Your final score is: %d out of %d%n", wins, ROUNDS_TOTAL);
    }

    public void closeScanner() {
        input.close();
    }

    public static void main(String[] args) {
        EnhancedEnigma game = new EnhancedEnigma();
        game.playGame();
        game.closeScanner();
    }
}
