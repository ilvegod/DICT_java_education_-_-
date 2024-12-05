import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        String botName = "Bot1";
        int birthYear = 2024;

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");

        System.out.println("Please, remind me your name.");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        System.out.println("What a great name you have, " + userName + "!");

        scanner.close();
    }
}


