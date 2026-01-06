import java.util.*;
public class Main {

    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();
        
        int[] dp = new int[m1 + m2 + m3 + m4];
        int idx = 0;
        int curR = r;
        int curC = c;

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <= m1; i++) {
            dp[idx++] = grid[curR][curC];
            list.add(new int[] {curR, curC});
            if (i + 1 > m1) break;
            curR += dr[0];
            curC += dc[0];
        }
        for (int i = 0; i < m2; i++) {
            curR += dr[1];
            curC += dc[1];
            dp[idx++] = grid[curR][curC];
            list.add(new int[] {curR, curC});
        }
        for (int i = 0; i < m3; i++) {
            curR += dr[2];
            curC += dc[2];
            dp[idx++] = grid[curR][curC];
            list.add(new int[] {curR, curC});
        }
        for (int i = 1; i < m4; i++) {
            curR += dr[3];
            curC += dc[3];
            dp[idx++] = grid[curR][curC];
            list.add(new int[] {curR, curC});
        }

        // for (int x : dp) {
        //     System.out.print(x + " ");
        // }
        // System.out.println();

        if (dir == 1) {
            int tmp = dp[0];
            for (int i = 0; i < dp.length - 1; i++) {
                dp[i] = dp[i + 1];
            }
            dp[dp.length - 1] = tmp;
        } else {
            int tmp = dp[dp.length - 1];
            for (int i = dp.length - 1; i > 0; i--) {
                dp[i] = dp[i - 1];
            }
            dp[0] = tmp;
        } 
        
        idx = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] coord = list.get(i);
            grid[coord[0]][coord[1]] = dp[idx++];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}