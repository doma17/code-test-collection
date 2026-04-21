import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[2 * n + 1][n + 1];
        for (int i = 0; i <= 2 * n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= 2 * n; i++) {
            int red = sc.nextInt();
            int blue = sc.nextInt();

            for (int j = 0; j <= n; j++) {
                int blueCount = i - j - 1;

                if (j > 0 && dp[i - 1][j - 1] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + red);
                }

                if (blueCount < n && dp[i - 1][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + blue);
                }
            }
        }

        System.out.println(dp[2 * n][n]);
    }
}