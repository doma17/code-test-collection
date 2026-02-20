import java.util.*;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int n, k;
    static int[][] grid;
    static int[][] starts;
    static boolean[][] visited;

    static int count = 0;

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] next = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = next[0] + dr[i];
                int nc = next[1] + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] == 1) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];
        for (int i = 0; i < k; i++) {;
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            if (visited[r][c]) continue;
            visited[r][c] = true;
            count++;
            bfs(r, c);
        }
        System.out.println(count);
    }
}