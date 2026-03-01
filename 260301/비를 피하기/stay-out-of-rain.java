import java.util.*;

public class Main {

    static int n, h, m;
    static int[][] a;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2)
                    list.add(new int[] {i, j});
            }
        }
        
        int[][] result = new int[n][n];
        for (int[] human : list) {
            result[human[0]][human[1]] = bfs(human[0], human[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(result[i][j] + " ");
            if (i + 1 != n) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int r, int c) {
        int[][] step = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        boolean[][] visited = new boolean[n][n];
        visited[r][c] = true;

        int destR = -1;
        int destC = -1;

        while (!q.isEmpty()) {
            int[] next = q.poll();
            if (a[next[0]][next[1]] == 3) {
                destR = next[0];
                destC = next[1];
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = next[0] + dr[i];
                int nc = next[1] + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (a[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                step[nr][nc] = step[next[0]][next[1]] + 1;
                q.add(new int[] {nr, nc});
            }
        }

        if (destR == -1 && destC == -1) 
            return -1;
        return step[destR][destC];
    }
}