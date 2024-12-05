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
                System.out.println("No improvements");
                continue;
            }

            guessedLetters += userGuess;

            if (wordToGuess.contains(userGuess)) {
                boolean isUpdated = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == userGuess.charAt(0) && currentWord.charAt(i) == '-') {
                        currentWord.setCharAt(i, userGuess.charAt(0));
                        isUpdated = true;
                    }
                }
                System.out.println(currentWord);
                if (!isUpdated) {
                    attemptsLeft--;
                    System.out.println("That letter doesn't appear in the word");
                }
            } else {
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word");
                System.out.println(currentWord);
            }

            if (currentWord.toString().equals(wordToGuess)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }

            if (attemptsLeft == 0) {
                System.out.println("You lost!");
                break;
            }
        }

        scanner.close();
    }
}
