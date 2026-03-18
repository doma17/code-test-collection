import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int[][] max = new int[n][n];
        max[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            max[0][i] = Math.max(grid[0][i], max[0][i - 1]);
        }
        for (int i = 1; i < n; i++) {
            max[i][0] = Math.max(grid[i][0], max[i - 1][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                max[i][j] = Math.max(Math.min(max[i - 1][j], max[i][j - 1]), grid[i][j]);
            }
        }
        System.out.println(max[n - 1][n - 1]);

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) System.out.print(max[i][j] + " ");
        //     System.out.println();
        // }
    }
}