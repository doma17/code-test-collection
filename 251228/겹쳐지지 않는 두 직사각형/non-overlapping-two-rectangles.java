import java.util.*;

public class Main {

    static int N, M;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N - 1; i++) {
            // 세로 선으로 분할
            int left = getMaxSumInArea(0, 0, i, M - 1);
            int right = getMaxSumInArea(i + 1, 0, N - 1, M - 1);
            
            if (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE) continue;
            // System.out.println(i + " " + left + " " + right);
            answer = Math.max(answer, left + right);
        }
        for (int j = 0; j < M - 1; j++) {
            // 가로 선으로 분할
            int top = getMaxSumInArea(0, 0, N - 1, j);
            int bottom = getMaxSumInArea(0, j + 1, N - 1, M - 1);

            if (top == Integer.MIN_VALUE || bottom == Integer.MIN_VALUE) continue;
            // System.out.println(j + " " + top + " " + bottom);
            answer = Math.max(answer, top + bottom);
        }
        System.out.println(answer);
    }

    static int getMaxSumInArea(int startR, int startC, int endR, int endC) {
        int maxSum = Integer.MIN_VALUE;

        for (int r1 = startR; r1 <= endR; r1++) {
            for (int c1 = startC; c1 <= endC; c1++) {

                for (int r2 = r1; r2 <= endR; r2++) {
                    for (int c2 = c1; c2 <= endC; c2++) {

                        // 누적합으로 바꿔도 됨.
                        int curSum = 0;
                        for (int r = r1; r <= r2; r++) {
                            for (int c = c1; c <= c2; c++) {
                                curSum += grid[r][c];
                            }
                        }
                        maxSum = Math.max(maxSum, curSum);
                    }
                }
            }
        }
        return maxSum;
    }
}