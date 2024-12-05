import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();

        String wordToGuess = words[random.nextInt(words.length)];
        String hint = wordToGuess.substring(0, 2) + "-".repeat(wordToGuess.length() - 2);

        System.out.println("HANGMAN");
        System.out.println("Guess the word " + hint + ": > ");
        String userGuess = scanner.nextLine();

        if (userGuess.equalsIgnoreCase(wordToGuess)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
