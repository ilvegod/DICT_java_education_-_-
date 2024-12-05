import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();

        String wordToGuess = words[random.nextInt(words.length)];
        StringBuilder currentWord = new StringBuilder("-".repeat(wordToGuess.length()));
        int attemptsLeft = 8;
        String guessedLetters = "";

        System.out.println("HANGMAN");
        System.out.println(currentWord);

        while (attemptsLeft > 0) {
            System.out.print("Input a letter: > ");
            String userGuess = scanner.nextLine().toLowerCase();

            if (guessedLetters.contains(userGuess)) {
                System.out.println("You've already guessed that letter.");
                continue;
            }

            guessedLetters += userGuess;

            if (wordToGuess.contains(userGuess)) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == userGuess.charAt(0)) {
                        currentWord.setCharAt(i, userGuess.charAt(0));
                    }
                }
                System.out.println(currentWord);
                if (currentWord.toString().equals(wordToGuess)) {
                    System.out.println("You survived!");
                    break;
                }
            } else {
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word");
                System.out.println(currentWord);
            }

            if (attemptsLeft == 0) {
                System.out.println("Thanks for playing!");
                System.out.println("We'll see how well you did in the next stage");
            }
        }

        scanner.close();
    }
}
