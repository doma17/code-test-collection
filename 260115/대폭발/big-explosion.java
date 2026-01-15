import java.util.Scanner;

public class Main {

    static int n, m, r, c;
    static int[][] dp;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        dp = new int[n][n];
        dp[r][c] = 1;

        for (int t = 1; t <= m; t++) {
            int[][] nextDp = new int[n][n];
            
            // 폭탄이 설치된 시간이 아니라 현재 시간
            int dist = (int) Math.pow(2, t - 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > 0) {
                        nextDp[i][j] = dp[i][j] + 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k] * dist;
                            int nc = j + dc[k] * dist;

                            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                            if (nextDp[nr][nc] == 0) {
                                nextDp[nr][nc] = 1;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {   
                if (dp[i][j] > 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}