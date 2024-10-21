//PINKACHU
import java.util.Scanner;

public class matricesArithmetic {

    public static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("The matrices must be of the same dimensions!");
            return null;
        }

        int[][] output = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                output[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return output;
    }

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("The number of columns for the first matrix and the number of rows of the second matrix must be the same!");
            return null;
        }

        int[][] output = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                output[i][j] = 0; 
                for (int k = 0; k < matrix2.length; k++) {
                    output[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Print the dimensions of your first matrix:");
        System.out.print("No. of rows: ");
        int rows1 = scanner.nextInt();
        System.out.print("No. of columns: ");
        int cols1 = scanner.nextInt();

        System.out.println("\nEnter your values:");
        int[][] matrix1 = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            System.out.println("Row " + (i + 1) + ": ");
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMatrix 1:");
        printMatrix(matrix1);

        System.out.println("Print the dimensions of your second matrix:");
        System.out.print("No. of rows: ");
        int rows2 = scanner.nextInt();
        System.out.print("No. of columns: ");
        int cols2 = scanner.nextInt();

        System.out.println("\nEnter your values:");
        int[][] matrix2 = new int[rows2][cols2];
        for (int i = 0; i < rows2; i++) {
            System.out.println("Row " + (i + 1) + ": ");
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMatrix 2:");
        printMatrix(matrix2);

        System.out.print("\nChoose your operation:\n1: Addition\n2: Multiplication\n\n: ");
        int operation = scanner.nextInt();

        int[][] output;
        if (operation == 1) {
            output = addMatrix(matrix1, matrix2);
            if (output != null) {
                System.out.println("\nSum of the matrices is:");
                printMatrix(output);
            }
        } else if (operation == 2) {
            output = multiplyMatrix(matrix1, matrix2);
            if (output != null) {
                System.out.println("\nProduct of the matrices is:");
                printMatrix(output);
            }
        } else {
            System.out.println("\nInvalid operation");
        }

        scanner.close();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
