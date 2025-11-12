import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int maxCoin = 0;
        for (int r = 0; r < n; r++) {
            int curCoin = grid[r][0] + grid[r][1] + grid[r][2];
            maxCoin = Math.max(maxCoin, curCoin);
            if (maxCoin >= 3) break;
            for (int c = 3; c < n; c++) {
                curCoin += grid[r][c] - grid[r][c - 3];
                maxCoin = Math.max(maxCoin, curCoin);
            }
        }
        System.out.println(maxCoin);
    }
}