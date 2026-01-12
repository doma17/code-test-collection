import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        

        int contactR = n - 1;
        for (int r = 0; r < n; r++) {
            boolean isContacted = false;
            for (int c = k - 1; c < k + m - 1; c++) {
                if (grid[r][c] == 1) {
                    isContacted = true;
                    break;
                }
            }

            if (isContacted) {
                contactR = r - 1;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (contactR >= 0) {
            for (int c = k - 1; c < k + m - 1; c++) {
                grid[contactR][c] = 1;
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) 
                sb.append(grid[r][c]).append(" ");
            if (r + 1 < n) sb.append("\n");
        }
        System.out.println(sb);
    }
}