import java.util.*;

public class Main {
    
    static int n, k;
    static int[][] grid;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void moveAndFindMax(int startR, int startC) {
        int r = startR;
        int c = startC;

        for (int cnt = 0; cnt < k; cnt++) {
            boolean[][] visited = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();
            
            q.add(new int[]{r, c});
            visited[r][c] = true;
            
            int startValue = grid[r][c];
            int maxVal = 0;
            int bestR = -1;
            int bestC = -1;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int currR = curr[0];
                int currC = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nr = currR + dx[i];
                    int nc = currC + dy[i];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (!visited[nr][nc] && grid[nr][nc] < startValue) {
                            visited[nr][nc] = true;
                            q.add(new int[]{nr, nc});

                            if (grid[nr][nc] > maxVal) {
                                maxVal = grid[nr][nc];
                                bestR = nr;
                                bestC = nc;
                            } else if (grid[nr][nc] == maxVal) {
                                if (nr < bestR) {
                                    bestR = nr;
                                    bestC = nc;
                                } else if (nr == bestR && nc < bestC) {
                                    bestR = nr;
                                    bestC = nc;
                                }
                            }
                        }
                    }
                }
            }

            if (bestR == -1 && bestC == -1) {
                break; 
            }

            r = bestR;
            c = bestC;
        }
        System.out.println((r + 1) + " " + (c + 1));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        moveAndFindMax(r, c);
    }
}