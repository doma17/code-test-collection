import java.io.*;

public class Main {

    static int n;
    static int k;
    static int[][] dp;
    static boolean[] visited;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);
        dp = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                dp[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        
        // N^3 이지만, N의 최대 크기가 작기 때문에 가능
        for (int x = 0; x < n; x++) {
            for (int i = 0; i < n; i++) {
                if (i == x) continue;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][x] + dp[x][j]);
                }
            }
        }

        visited[k] = true;
        dfs(k, 0, 1);
        System.out.println(minTime);
    }

    private static void dfs(int cur, int time, int count) {
        if (time >= minTime) return;
        else if (count == n) {
            minTime = Math.min(minTime, time);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, time + dp[cur][i], count + 1);
            visited[i] = false;
        }
    }
}