import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int[][] matrixA = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        int n2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int[][] matrixB = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        if (n1 == n2 && m1 == m2) {
            int[][] result = new int[n1][m1];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }
}
