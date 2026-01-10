import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] tmp = copyGrid(grid);
                bomb(tmp, i, j);
                tmp = gravity(tmp);
                int count = getPair(tmp);
                answer = Math.max(answer, count);
            }
        }
        System.out.println(answer);
    }

    private static int[][] copyGrid(int[][] grid) {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmp[i] = grid[i].clone();
        }
        return tmp;
    }

    private static void bomb(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) return;
        
        int range = grid[r][c];
        grid[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < range; j++) {
                int nr = r + dr[i] * j;
                int nc = c + dc[i] * j;

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    grid[nr][nc] = 0;
                }
            } 
        }
    }

    private static int[][] gravity(int[][] grid) {
        int[][] tmp = new int[n][n];
        for (int j = 0; j < n; j++) {
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    tmp[idx--][j] = grid[i][j];
                }
            }
        }
        return tmp;
    }

    private static int getPair(int[][] grid) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                if (i + 1 < n) {
                    if (grid[i][j] == grid[i + 1][j])
                        count++;
                }
                if (j + 1 < n) {
                    if (grid[i][j] == grid[i][j + 1])
                        count++;
                }
            }
        }
        return count;
    }
}