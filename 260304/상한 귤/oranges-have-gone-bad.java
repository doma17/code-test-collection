import java.util.*;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int n, k;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] != 1) continue;

                result[nr][nc] = result[now.r][now.c] + 1;
                visited[nr][nc] = true;
                q.add(new Node(nr, nc));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    if (visited[i][j]) sb.append(result[i][j] + " ");
                    else sb.append(-2 + " ");
                } else {
                    sb.append(-1 + " ");
                }
            }
            if (i + 1 != n) sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node {

        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}