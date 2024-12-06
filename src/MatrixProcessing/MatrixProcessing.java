import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrixA = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        int[][] matrixB = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        if (n == matrixB.length && m == matrixB[0].length) {
            int[][] sumMatrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(sumMatrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }

        int constant = scanner.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] * constant + " ");
            }
            System.out.println();
        }
    }
}
