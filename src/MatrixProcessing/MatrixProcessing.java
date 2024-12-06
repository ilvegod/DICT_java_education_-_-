import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
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

                int[][] result = new int[m][n];
                if (transposeChoice == 1) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[j][i] = matrix[i][j];
                        }
                    }
                } else if (transposeChoice == 2) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[m - j - 1][n - i - 1] = matrix[i][j];
                        }
                    }
                } else if (transposeChoice == 3) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[i][m - j - 1] = matrix[i][j];
                        }
                    }
                } else if (transposeChoice == 4) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            result[n - i - 1][j] = matrix[i][j];
                        }
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

            if (choice == 5) {
                System.out.print("Enter matrix size: ");
                int n = scanner.nextInt();
                int m = scanner.nextInt();

                if (n != m) {
                    System.out.println("The matrix must be square.");
                    continue;
                }

                double[][] matrix = new double[n][m];
                System.out.println("Enter matrix:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        matrix[i][j] = scanner.nextDouble();
                    }
                }

                double determinant = calculateDeterminant(matrix, n);
                System.out.println("The result is:");
                System.out.println(determinant);
            }

            if (choice == 6) {
                System.out.print("Enter matrix size: ");
                int n = scanner.nextInt();
                int m = scanner.nextInt();

                if (n != m) {
                    System.out.println("The matrix must be square.");
                    continue;
                }

                double[][] matrix = new double[n][m];
                System.out.println("Enter matrix:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        matrix[i][j] = scanner.nextDouble();
                    }
                }

                double[][] inverseMatrix = calculateInverse(matrix, n);
                if (inverseMatrix != null) {
                    System.out.println("The result is:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(inverseMatrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("The matrix is not invertible.");
                }
            }
        }
    }

    public static double calculateDeterminant(double[][] matrix, int n) {
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double determinant = 0;
        for (int i = 0; i < n; i++) {
            double[][] subMatrix = new double[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                int k = 0;
                for (int l = 0; l < n; l++) {
                    if (l != i) {
                        subMatrix[j - 1][k++] = matrix[j][l];
                    }
                }
            }
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(subMatrix, n - 1);
        }

        return determinant;
    }

    public static double[][] calculateInverse(double[][] matrix, int n) {
        double determinant = calculateDeterminant(matrix, n);
        if (determinant == 0) {
            return null;
        }

        double[][] adjoint = new double[n][n];
        if (n == 2) {
            adjoint[0][0] = matrix[1][1];
            adjoint[0][1] = -matrix[0][1];
            adjoint[1][0] = -matrix[1][0];
            adjoint[1][1] = matrix[0][0];
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double[][] subMatrix = new double[n - 1][n - 1];
                    for (int k = 0; k < n; k++) {
                        if (k != i) {
                            for (int l = 0; l < n; l++) {
                                if (l != j) {
                                    subMatrix[k < i ? k : k - 1][l < j ? l : l - 1] = matrix[k][l];
                                }
                            }
                        }
                    }
                    adjoint[j][i] = Math.pow(-1, i + j) * calculateDeterminant(subMatrix, n - 1);
                }
            }
        }

        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = adjoint[i][j] / determinant;
            }
        }

        return inverseMatrix;
    }
}
