import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int[][] min = new int[n][n];
        min[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            min[0][i] = Math.min(matrix[0][i], min[0][i - 1]);
        }
        for (int i = 1; i < n; i++) {
            min[i][0] = Math.min(matrix[i][0], min[i - 1][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                min[i][j] = Math.min(Math.max(min[i - 1][j], min[i][j - 1]), matrix[i][j]);
            }
        }
        System.out.println(min[n - 1][n - 1]);

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) System.out.print(min[i][j] + " ");
        //     System.out.println();
        // }
    }
}