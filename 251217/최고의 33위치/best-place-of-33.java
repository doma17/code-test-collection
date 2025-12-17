import java.util.*;

public class Main {

    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int maxSum = -1;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxSum = Math.max(maxSum, getSum(i, j));
            }
        }
        System.out.println(maxSum);
    }

    private static int getSum(int i, int j) {
        int sum = 0;
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++){
                sum += grid[r][c];
            }
        }
        return sum;
    }
}