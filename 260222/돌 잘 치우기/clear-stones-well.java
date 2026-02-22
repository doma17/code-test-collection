import java.util.*;

public class Main {

    static int n, k, m;
    static int[][] grid;
    static int[][] startPoints;

    static boolean[][] canMove;
    static boolean[][] visited;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int answer = 0;

    private static int bfs(int r, int c) {
        int count = 0;
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});

        while (!q.isEmpty()) {
            int[] next = q.poll();
            count++;
            
            for (int i = 0; i < 4; i++) {
                int nr = next[0] + dr[i];
                int nc = next[1] + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }
        return count;
    }

    private static void dfs(int num) {
        visited = new boolean[n][n];
        int totalCount = 0;
        if (num == m) {
            for (int i = 0; i < k; i++) {
                if (!visited[startPoints[i][0]][startPoints[i][1]])
                    totalCount += bfs(startPoints[i][0], startPoints[i][1]);
            }
            answer = Math.max(answer, totalCount);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (canMove[i][j]) continue;
                canMove[i][j] = true;
                grid[i][j] = 0;
                dfs(num + 1);
                canMove[i][j] = false;
                grid[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt() - 1;
            startPoints[i][1] = sc.nextInt() - 1;
        }

        canMove = new boolean[n][n];
        dfs(0);
        System.out.println(answer);
    }
}