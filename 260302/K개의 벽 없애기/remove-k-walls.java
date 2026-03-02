import java.util.*;

public class Main {
    static class State {
        int r, c, b;
        State(int r, int c, int b) {
            this.r = r;
            this.c = c;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;

        int[][][] dist = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int startBroken = (grid[r1][c1] == 1) ? 1 : 0;
        if (startBroken > k) {
            System.out.println(-1);
            return;
        }

        Queue<State> q = new LinkedList<>();
        q.offer(new State(r1, c1, startBroken));
        dist[r1][c1][startBroken] = 0;

        while (!q.isEmpty()) {
            State cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                int nb = cur.b + (grid[nr][nc] == 1 ? 1 : 0);
                if (nb > k) continue;
                if (dist[nr][nc][nb] != -1) continue;

                dist[nr][nc][nb] = dist[cur.r][cur.c][cur.b] + 1;
                q.offer(new State(nr, nc, nb));
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int b = 0; b <= k; b++) {
            if (dist[r2][c2][b] != -1) {
                answer = Math.min(answer, dist[r2][c2][b]);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
