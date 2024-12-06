import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice == 1) {
                System.out.print("Enter size of first matrix: ");
                int n1 = scanner.nextInt();
                int m1 = scanner.nextInt();
                int[][] matrixA = new int[n1][m1];
                System.out.println("Enter first matrix:");
                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m1; j++) {
                        matrixA[i][j] = scanner.nextInt();
                    }
                }

                System.out.print("Enter size of second matrix: ");
                int n2 = scanner.nextInt();
                int m2 = scanner.nextInt();
                int[][] matrixB = new int[n2][m2];
                System.out.println("Enter second matrix:");
                for (int i = 0; i < n2; i++) {
                    for (int j = 0; j < m2; j++) {
                        matrixB[i][j] = scanner.nextInt();
                    }
                }

                if (n1 == n2 && m1 == m2) {
                    int[][] sumMatrix = new int[n1][m1];
                    for (int i = 0; i < n1; i++) {
                        for (int j = 0; j < m1; j++) {
                            sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
                        }
                    }

                    System.out.println("The result is:");
                    for (int i = 0; i < n1; i++) {
                        for (int j = 0; j < m1; j++) {
                            System.out.print(sumMatrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("The operation cannot be performed.");
                }
            }

            if (choice == 2) {
                System.out.print("Enter size of matrix: ");
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                double[][] matrix = new double[n][m];
                System.out.println("Enter matrix:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        matrix[i][j] = scanner.nextDouble();
                    }
                }

                System.out.print("Enter constant: ");
                double constant = scanner.nextDouble();

                System.out.println("The result is:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(matrix[i][j] * constant + " ");
                    }
                    System.out.println();
                }
            }

            if (choice == 3) {
                System.out.print("Enter size of first matrix: ");
                int n1 = scanner.nextInt();
                int m1 = scanner.nextInt();
                int[][] matrixA = new int[n1][m1];
                System.out.println("Enter first matrix:");
                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m1; j++) {
                        matrixA[i][j] = scanner.nextInt();
                    }
                }

                System.out.print("Enter size of second matrix: ");
                int n2 = scanner.nextInt();
                int m2 = scanner.nextInt();
                if (m1 != n2) {
                    System.out.println("The operation cannot be performed.");
                    continue;
                }
                int[][] matrixB = new int[n2][m2];
                System.out.println("Enter second matrix:");
                for (int i = 0; i < n2; i++) {
                    for (int j = 0; j < m2; j++) {
                        matrixB[i][j] = scanner.nextInt();
                    }
                }

                int[][] result = new int[n1][m2];
                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m2; j++) {
                        for (int k = 0; k < m1; k++) {
                            result[i][j] += matrixA[i][k] * matrixB[k][j];
                        }
                    }
                }

                System.out.println("The result is:");
                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m2; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println();
                }
            }

            if (choice == 4) {
                System.out.println("1. Main diagonal");
                System.out.println("2. Side diagonal");
                System.out.println("3. Vertical line");
                System.out.println("4. Horizontal line");
                System.out.print("Your choice: ");
                int transposeChoice = scanner.nextInt();

                System.out.print("Enter matrix size: ");
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int[][] matrix = new int[n][m];
                System.out.println("Enter matrix:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                if (transposeChoice == 1) {
                    int[][] result = new int[m][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[j][i] = matrix[i][j];
                        }
                    }

                    System.out.println("The result is:");
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }
                }

                if (transposeChoice == 2) {
                    int[][] result = new int[m][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[m - j - 1][n - i - 1] = matrix[i][j];
                        }
                    }

                    System.out.println("The result is:");
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }
                }

                if (transposeChoice == 3) {
                    int[][] result = new int[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[i][m - j - 1] = matrix[i][j];
                        }
                    }

                    System.out.println("The result is:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }
                }

                if (transposeChoice == 4) {
                    int[][] result = new int[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[n - i - 1][j] = matrix[i][j];
                        }
                    }

                    System.out.println("The result is:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(result[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }

        scanner.close();
    }
}
