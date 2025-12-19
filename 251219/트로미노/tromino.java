import java.util.Scanner;

public class Main {

    private static int[][] grid;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int maxAnswer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxAnswer = Math.max(maxAnswer, getMaxSumTarget(i, j));
            }
        }
        System.out.println(maxAnswer);
    }

    private static int getMaxSumTarget(int r, int c) {
        int maxSum = 0;

        if (r - 1 >= 0 && r + 1 < n) {
            maxSum = Math.max(maxSum, grid[r - 1][c] + grid[r][c] + grid[r + 1][c]);
        }

        if (r + 1 < n && c + 1 < m) {
            maxSum = Math.max(maxSum, grid[r][c] + grid[r + 1][c] + grid[r][c + 1]);
        }
        return maxSum;
    }
}