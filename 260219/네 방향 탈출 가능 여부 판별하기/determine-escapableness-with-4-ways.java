import java.util.*;

public class Main {

    static int n, m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        bfs();
    }

    private static void bfs() {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] next = q.poll();
            int r = next[0];
            int c = next[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }

        if (visited[n - 1][m - 1]) System.out.println(1);
        else System.out.println(0);
    }
}