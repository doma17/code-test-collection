import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '.') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        for (int r = 0; r < n; r++){
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 1) dp[r][c] = getIsland(r, c);
            }
        }

//        // Output
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }

        int topR = n;
        int bottomR = 0;
        int leftC = m;
        int rightC = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == 1) {
                    topR = Math.min(topR, i);
                    bottomR = Math.max(bottomR, i);
                    leftC = Math.min(leftC, j);
                    rightC = Math.max(rightC, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = topR; i < bottomR + 1; i++) {
            for (int j = leftC; j < rightC + 1; j++) {
                if (dp[i][j] == 1) sb.append("X");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    private static int getIsland(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;

            // 주변에 섬 개수를 센다
            if (map[nextR][nextC] == 1) cnt++;
        }

        // 인접한 3, 4칸 바다면 잠김
        if (cnt >= 2) {
            return 1;
        }
        return 0;
    }
}