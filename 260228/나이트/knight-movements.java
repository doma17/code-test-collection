import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;

        int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r1, c1});
        boolean[][] visited = new boolean[n][n];
        visited[r1][c1] = true;

        int[][] a = new int[n][n];
        while (!q.isEmpty()) {
            int[] next = q.poll();

            for (int i = 0; i < 8; i++) {
                int nr = next[0] + dr[i];
                int nc = next[1] + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                a[nr][nc] = a[next[0]][next[1]] + 1;
                q.add(new int[] {nr, nc});
            }
        }
        if (!visited[r2][c2])
            System.out.println(-1);
        else 
            System.out.println(a[r2][c2]);
    }
}