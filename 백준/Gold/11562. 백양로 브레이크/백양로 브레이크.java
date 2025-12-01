import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        // 모든 길은 최대 값으로 초기화
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                // 자기 자신은 0 값을 가지게됨
                if (i == j) continue;
                dp[i][j] = 10000000;
            }
        }

        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int u = Integer.parseInt(tmp[0]);
            int v = Integer.parseInt(tmp[1]);
            int b = Integer.parseInt(tmp[2]);

            dp[u][v] = 0;
            // 일방통행이면 역방향은 1의 비용을 가지게 된다.
            if (b == 0) dp[v][u] = 1;
            else dp[v][u] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);

            sb.append(dp[s][e] + "\n");
        }
        System.out.println(sb.toString());
    }
}