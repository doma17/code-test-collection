import java.util.*;
public class Main {

    static int MIN = -100000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], MIN);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];

            for (int j = 0; j <= 3; j++) {
                if (i >= 2 && dp[i - 2][j] != MIN) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + coins[i - 1]);
                }
                if (i >= 1 && j >= 1 && dp[i - 1][j - 1] != MIN) {   
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + coins[i - 1]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 3; i++) {
            answer = Math.max(answer, dp[n][i]);
        }
        System.out.println(answer);
    }
}