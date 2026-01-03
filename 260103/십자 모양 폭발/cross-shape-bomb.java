import java.util.*;

public class Main {

    static int n;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        
        bomb(r, c);
        grid = calcGravity();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j] + " ");
            }
            if (i + 1 != n) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bomb(int r, int c) {
        int size = grid[r][c];
        grid[r][c] = 0;

        for (int i = 1; i < size; i++) {
            if (c + i >= n) break;
            grid[r][c + i] = 0;
        }
        for (int i = 1; i < size; i++) {
            if (c - i < 0) break;
            grid[r][c - i] = 0;
        }
        for (int i = 1; i < size; i++) {
            if (r + i >= n) break;
            grid[r + i][c] = 0;
        }
        for (int i = 1; i < size; i++) {
            if (r - i <0) break;
            grid[r - i][c] = 0;
        }
    }

    private static int[][] calcGravity() {
        int[][] map = new int[n][n];
        
        // 각 열에서 아래서부터 훑기
        for (int c = 0; c < n; c++) {
            int idx = n - 1;
            for (int r = n - 1; r >= 0; r--) {
                if (grid[r][c] == 0) continue;
                map[idx--][c] = grid[r][c];
            }
        }

        return map;
    }
}