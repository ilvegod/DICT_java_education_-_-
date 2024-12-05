import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        if (input.length() == 9 && input.matches("[XO_]+")) {
            printBoard(input);

            while (true) {
                System.out.print("Enter the coordinates: ");
                String[] coordinates = scanner.nextLine().split(" ");
                if (coordinates.length != 2) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                try {
                    int row = Integer.parseInt(coordinates[0]) - 1;
                    int col = Integer.parseInt(coordinates[1]) - 1;

                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else {
                        if (input.charAt(row * 3 + col) == 'X' || input.charAt(row * 3 + col) == 'O') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            input = input.substring(0, row * 3 + col) + "X" + input.substring(row * 3 + col + 1);
                            printBoard(input);
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                }
            }
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static void printBoard(String input) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(input.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
