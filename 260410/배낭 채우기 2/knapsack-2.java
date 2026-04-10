import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < w[j]) continue;
                dp[i] = Math.max(dp[i], dp[i - w[j]] + v[j]);
            }
        }

        // for (int i = 0; i <= m; i++) System.out.print(dp[i] + " ");
        // System.out.println();

        int answer = 0;
        for (int i = 0; i <= m; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}