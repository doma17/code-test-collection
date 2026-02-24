import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        int lastMeltCount = 0;

        while (true) {
            int meltedThisTurn = meltGlacier();
            if (meltedThisTurn == 0) break;
            
            lastMeltCount = meltedThisTurn;
            time++;
        }

        System.out.println(time + " " + lastMeltCount);
    }

    private static int meltGlacier() {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> meltList = new ArrayList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    
                    if (grid[nr][nc] == 0) q.add(new int[]{nr, nc});
                    else if (grid[nr][nc] == 1) meltList.add(new int[]{nr, nc});
                }
            }
        }
        
        for (int[] pos : meltList) {
            grid[pos[0]][pos[1]] = 0;
        }
        return meltList.size();
    }
}