import java.util.*;

public class Main {

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] count = new int[n][n];
        for (int i = 0; i < m; i++) {
            count[sc.nextInt() - 1][sc.nextInt() - 1]++;
        }
        
        while (t-- > 0) {
            int[][] nextCount = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] > 0) {
                        // 방향이동
                        int nextR = i;
                        int nextC = j;
                        int nextValue = 0;
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];

                            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                            if (grid[nr][nc] > nextValue) {
                                nextValue = grid[nr][nc];
                                nextR = nr;
                                nextC = nc;
                            }
                        }
                        nextCount[nextR][nextC]++;
                    }
                }
            }
            count = nextCount;

            // 충돌 제거
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] > 1) count[i][j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] > 0) answer++;
            }
        }
        System.out.println(answer);
    }
}