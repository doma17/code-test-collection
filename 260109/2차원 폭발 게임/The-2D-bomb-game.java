import java.util.*;

public class Main {

    static int n, m, k;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for (int i = 0; i < k; i++) {
            boolean t = true;
            while (t) {                
                t = bomb();
                gravity();
            }
            pivot();
            gravity();
        }
        boolean t = true;
        while (t) {                
            t = bomb();
            gravity();
        }

        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j] + " ");
                if (grid[i][j] != 0) answer++;
            }
                
            if (i + 1 != n) sb.append("\n");
        }
        // System.out.println(sb);
        System.out.println(answer);
    }

    // 폭탄 터지기 로직
    private static boolean bomb() {
        boolean isExploded = false;
        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < n) {
                if (grid[i][j] == 0) {
                    i++;
                    continue;
                }
                int end = i + 1;
                while (end < n && grid[end][j] == grid[i][j]) {
                    end++;
                }

                if (end - i >= m) {
                    isExploded = true;
                    for (int x = i; x < end; x++){
                        grid[x][j] = 0;
                    }
                }
                i = end;
            }
        }
        return isExploded;
    }

    // 중력 로직
    private static void gravity() {
        int[][] tmp = new int[n][n];
        for (int j = 0; j < n; j++) {
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] != 0) tmp[idx--][j] = grid[i][j];   
            }
        }
        grid = tmp;
    }

    // 피봇
    private static void pivot() {
        // 시계방향으로 90도 회전
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                tmp[j][n - 1 - i] = grid[i][j];
        } 
        grid = tmp;
    }
}