import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] grid;
    static int[] bombCols;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        bombCols = new int[m];
        for (int i = 0; i < m; i++)
            bombCols[i] = sc.nextInt() - 1;
        
        for (int i = 0; i < m; i++) {
            int col = bombCols[i];

            int r = 0;
            for (; r < n; r++) {
                if (grid[r][col] != 0) {
                    break;
                }
            }
            
            // 바닥이 아닌 경우
            if (r < n) {
                bomb(r, col);
                for (int c = 0; c < n; c++) 
                    gravity(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sb.append(grid[i][j] + " ");
            if (i + 1 != n) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bomb(int r, int c) {
        int range = grid[r][c];
        grid[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            for (int k = 1; k < range; k++) {
                int nr = r + dr[i] * k;
                int nc = c + dc[i] * k;
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    grid[nr][nc] = 0;
                }
            }
        }
    }

    private static void gravity(int c) {
        int[] tmp = new int[n];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            if (grid[i][c] != 0) tmp[idx++] = grid[i][c];
        }
        
        for (int i = 0; i < n; i++)
             grid[i][c] = 0;

        for (int i = 0; i < idx; i++) {
            grid[n - 1 - i][c] = tmp[idx - 1 - i];
        }
    }
}