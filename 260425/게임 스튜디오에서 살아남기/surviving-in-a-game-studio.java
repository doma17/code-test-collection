import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][][] dp = new long[N + 1][3][3];
        dp[0][0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int t = 0; t < 3; t++) {
                for (int b = 0; b < 3; b++) {
                    if (dp[i - 1][t][b] == 0) continue;

                    long currentVal = dp[i - 1][t][b];

                    dp[i][t][0] = (dp[i][t][0] + currentVal) % MOD;

                    if (b + 1 < 3) {
                        dp[i][t][b + 1] = (dp[i][t][b + 1] + currentVal) % MOD;
                    }

                    if (t + 1 < 3) {
                        dp[i][t + 1][0] = (dp[i][t + 1][0] + currentVal) % MOD;
                    }
                }
            }
        }

        long answer = 0;
        for (int t = 0; t < 3; t++) {
            for (int b = 0; b < 3; b++) {
                answer = (answer + dp[N][t][b]) % MOD;
            }
        }

        System.out.println(answer);
    }
}