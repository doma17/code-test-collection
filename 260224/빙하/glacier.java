import java.util.*;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int n, m;
    static int[][] grid;

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
        int lastIceCount = 0;
        
        while (true) {
            int currentIce = countGlacier();
            if (currentIce == 0) break;
            
            lastIceCount = currentIce;
            meltGlacier(); 
            time++;
        }
        
        System.out.println(time + " " + lastIceCount);
    }

    private static int countGlacier() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void meltGlacier() {
        boolean[][] visitedWater = new boolean[n][m];
        boolean[][] canMelt = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visitedWater[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    List<int[]> pool = new ArrayList<>();
                    
                    q.add(new int[]{i, j});
                    visitedWater[i][j] = true;
                    boolean isEdge = false;
                    
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];
                        pool.add(curr);
                        
                        if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
                            isEdge = true;
                        }
                        
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (grid[nr][nc] == 0 && !visitedWater[nr][nc]) {
                                    visitedWater[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    
                    if (isEdge || pool.size() >= 2) {
                        for (int[] p : pool) {
                            canMelt[p[0]][p[1]] = true;
                        }
                    }
                }
            }
        }

        List<int[]> meltList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                            if (grid[nr][nc] == 0 && canMelt[nr][nc]) {
                                meltList.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int[] pos : meltList) {
            grid[pos[0]][pos[1]] = 0;
        }
    }    
}