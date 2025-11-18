import java.io.*;

public class Main {

    static int n;
    static int[][] matrix;
    static int[][] dp;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int maxCount = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                maxCount = Math.max(maxCount, dfs(r, c));
            }
        }
        System.out.println(maxCount + 1);
    }

    static int dfs(int curR, int curC) {
        if (dp[curR][curC] != 0) return dp[curR][curC];

        for (int i = 0; i < 4; i++) {
            int nextR = curR + dr[i];
            int nextC = curC + dc[i];

            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
            if (matrix[curR][curC] < matrix[nextR][nextC]) {
                dp[curR][curC] = Math.max(dp[curR][curC], dfs(nextR, nextC) + 1);
            }
        }
        return dp[curR][curC];
    }
}