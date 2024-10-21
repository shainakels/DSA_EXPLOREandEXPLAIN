//PINKACHU
import java.util.Scanner;

public class CramerRuleValues {

    public static double determinant(double[][] matrix) {
        double det = 0;
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        for (int i = 0; i < n; i++) {
            double[][] subMatrix = new double[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        subMatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        subMatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            det += Math.pow(-1, i) * matrix[0][i] * determinant(subMatrix);
        }
        return det;
    }

    public static double[] solve(double[][] coefficients, double[] constants) {
        int n = coefficients.length;
        double[] results = new double[n];

        double det = determinant(coefficients);

        if (det == 0) {
            throw new IllegalArgumentException("The system has no unique solution.");
        }

        for (int i = 0; i < n; i++) {
            double[][] tempMatrix = new double[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    tempMatrix[j][k] = coefficients[j][k];
                }
                tempMatrix[j][i] = constants[j];
            }
            results[i] = determinant(tempMatrix) / det;
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of variables (equations): ");
        int n = scanner.nextInt();

        double[][] coefficients = new double[n][n];
        double[] constants = new double[n];

        System.out.println("Enter the coefficients for the equations:");
        for (int i = 0; i < n; i++) {
            System.out.print("Equation " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                coefficients[i][j] = scanner.nextDouble();
            }
            System.out.print("Constant term: ");
            constants[i] = scanner.nextDouble();
        }

        try {
            double[] solutions = solve(coefficients, constants);
            System.out.println("Solutions:");
            for (int i = 0; i < solutions.length; i++) {
                System.out.println("x" + (i + 1) + " = " + solutions[i]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
