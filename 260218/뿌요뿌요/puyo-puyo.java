import java.util.*;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int n;
    static int[][] grid;
    static boolean[][] visited;

    static int count;
    static int maxCount = 0;
    static int explodedCount = 0;

    private static void dfs(int r, int c, int num) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (visited[nr][nc]) continue;
            if (num != grid[nr][nc]) continue;

            visited[nr][nc] = true;
            count++;
            dfs(nr, nc, num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                count = 1;
                visited[i][j] = true;
                dfs(i, j, grid[i][j]);

                if (maxCount < count) {
                    maxCount = count;    
                }
                if (count >= 4) {
                    explodedCount++;
                }
            }
        }

        System.out.println(explodedCount + " " + maxCount);
    }
}