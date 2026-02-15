import java.util.*;

public class Main {

    static int n, m;
    static int[][] grid;
    static boolean[][] visited;

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(0);
    }

    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    private static void dfs(int r, int c) {
        if (r == n - 1 && c == m - 1) {
            System.out.println(1);
            System.exit(0);
        }

        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc] == 0) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}