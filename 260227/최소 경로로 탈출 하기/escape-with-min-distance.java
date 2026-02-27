import java.util.*;
public class Main {

    static int n, m;
    static int[][] a;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        
        System.out.println(bfs(0, 0));
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    private static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] step = new int[n][m];
        q.add(new int[] {r, c});
        visited[r][c] = true;
        

        while (!q.isEmpty()) {
            int[] next = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = next[0] + dr[i];
                int nc = next[1] + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (a[nr][nc] == 0) continue; 

                visited[nr][nc] = true;
                step[nr][nc] = step[next[0]][next[1]] + 1; 
                q.add(new int[] {nr, nc});
            }
        }
        if (visited[n - 1][n - 1])
            return step[n - 1][n - 1];
        return -1;
    }
}