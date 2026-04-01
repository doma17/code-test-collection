import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        Arrays.sort(coin);

        int[] dp = new int[m + 1];
        int MAX = 10000000;
        for (int i = 0; i <= m; i++) 
            dp[i] = MAX;
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= coin[i]) {
                    if (dp[j - coin[i]] == MAX) continue;
                    dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }

        if (dp[m] == MAX) System.out.println(-1);
        else System.out.println(dp[m]);
    }
}