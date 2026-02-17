import java.util.*;

public class Main {

    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    static int k = 1;
    static int maxK = 1;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        int maxHeight = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }
            
        for (; k <= maxHeight; k++) {
            visited = new boolean[n][m];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) continue;
                    if (k >= grid[i][j]) continue;
                    visited[i][j] = true;
                    dfs(i, j);
                    count++;
                }
            }

            if (answer < count) {
                answer = count;
                maxK = k;    
            }
        }
        System.out.println(maxK + " " + answer);
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    private static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (visited[nr][nc]) continue;
            if (k >= grid[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}