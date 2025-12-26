import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = 0;
        for (int c = 1; c < n - 1; c++) {
            answer = Math.max(answer, getBishopValue(0, c));
        }   
        System.out.println(answer);
    }

    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};

    static int[][] grid;
    static int n;

    private static int getBishopValue(int startR, int startC) {
        int dirIndex = 0;
        int sum = grid[startR][startC];

        int curR = startR;
        int curC = startC;
        while (dirIndex < 4) {
            int nextR = curR + dr[dirIndex];
            int nextC = curC + dc[dirIndex];
            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
                if (nextR == startR && nextC == startC) break; 
                
                curR = nextR;
                curC = nextC;
                sum += grid[curR][curC];
            } else {
                // 경계를 만나면 방향 바꿈
                dirIndex++;
            }
        }
        return sum;
    }
}