import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++)
            coin[i] = sc.nextInt();
        
        int INF = 1000000;
        int[] dp = new int[m + 1];
        for (int i = 0; i <= m; i++)
            dp[i] = INF;

        for (int i = 0; i < n; i++)
            dp[coin[i]] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                int ex = i - coin[j];
                if (ex < 0) break;
                dp[i] = Math.min(dp[i], dp[ex] + 1);
            }
        }

        // for (int i = 0; i <= m; i++) 
        //     System.out.print(dp[i] + " ");
        // System.out.println();
        
        if (dp[m] == INF) 
            System.out.println(-1);
        else 
            System.out.println(dp[m]);
    }
}