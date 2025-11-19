import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int[][] dp = new int[n][n - 2];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n - 2; c++) {
                dp[r][c] = arr[r][c] + arr[r][c + 1] + arr[r][c + 2];
            }
        }

        int max = 0;
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < n - 2; c1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    for (int c2 = 0; c2 < n - 2; c2++) {
                        if (r1 == r2 && Math.abs(c1 - c2) < 3) continue;
                        max = Math.max(max, dp[r1][c1] + dp[r2][c2]);
                    }
                }
            }
        }

        System.out.println(max);
    }
}