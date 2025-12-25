import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (int k = 0; k < n; k++) {
                    answer = Math.max(answer, getMaxGoldInK(r, c, k));
                }
            }
        }
        System.out.println(answer);
     }

    static int[][] grid;
    static int n;
    static int m;

    private static int getMaxGoldInK(int r, int c, int k) {
        int gold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(r - i) + Math.abs(c - j) <= k) {
                    gold += grid[i][j];
                }
            }
        }
        int goldCost = gold * m;
        int digCost = k * k + (k + 1) * (k + 1);

        // System.out.println(r + " " + c + " " + k + " : " + goldCost + " " + digCost);

        if (digCost > goldCost) return -1;
        return gold;
    }
}