import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] grid;
    static int[] bombCols;

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
            bombCols[i] = sc.nextInt();
        
        int[] tmp;
        for (int i = 0; i < m; i++) {
            int col = bombCols[i];
            for (int r = 0; r < n; r++) {
                if (grid[r][col] != 0) {
                    
                    break;
                }
            }

            for (int c = 0; c < n; c++) 
                gravity(c);
        }

    }

    private static void gravity(int c) {
        int[] tmp = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][c] != 0) tmp[idx++] = grid[i][c];
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            grid[n - 1 - i][c] = tmp[idx++];
        }
    }
}