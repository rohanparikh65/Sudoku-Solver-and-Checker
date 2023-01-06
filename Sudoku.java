import java.io.File;
import java.util.Scanner;

public class Sudoku {
    public static void correctorincorrect(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] != 0) {
                    for (int k = j + 1; k < 9; k++) {
                        if (matrix[i][k] == matrix[i][j]) {
                            System.out.println("incorrect");
                            return;
                        }
                    }
                    for (int k = i + 1; k < 9; k++) {
                        if (matrix[k][j] == matrix[i][j]) {
                            System.out.println("incorrect");
                            return;
                        }
                    }

                    int m = (int) (i / 3) * 3;
                    int n = (int) (j / 3) * 3;
                    int k, l;
                    for (k = m; k < 3 + m; ++k) {
                        for (l = n; l < 3 + n; ++l) {
                            if ((i != k || j != l) && (matrix[i][j] == matrix[k][l])) {
                                System.out.println("incorrect");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("correct");
    }

    public static void solvable(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] != 0) {
                    for (int k = j + 1; k < 9; k++) {
                        if (matrix[i][k] == matrix[i][j]) {
                            System.out.println("unsolvable");
                            return;
                        }
                    }
                    for (int k = i + 1; k < 9; k++) {
                        if (matrix[k][j] == matrix[i][j]) {
                            System.out.println("unsolvable");
                            return;
                        }
                    }

                    int m = (int) (i / 3) * 3;
                    int n = (int) (j / 3) * 3;
                    int k, l;
                    for (k = m; k < 3 + m; ++k) {
                        for (l = n; l < 3 + n; ++l) {
                            if ((i != k || j != l) && (matrix[i][j] == matrix[k][l])) {
                                System.out.println("unsolvable");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("solvable");
    }

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        int[][] matrix = new int[9][9];

        // Read the matrix from the file
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        correctorincorrect(matrix);
        solvable(matrix);

    }
}

        
