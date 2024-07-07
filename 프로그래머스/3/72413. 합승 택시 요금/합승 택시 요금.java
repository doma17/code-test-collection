import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int ans = 0;
        final int MAX_VALUE = 100000 * 200 + 1;

        // 값 초기화
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            matrix[i][i] = 0;
            Arrays.fill(matrix[i], MAX_VALUE);
        }
        for(int[] row : fares) {
            int x = row[0];
            int y = row[1];
            int value = row[2];
            matrix[x][y] = value;
            matrix[y][x] = value;
        }

        // 플로이드-워셜
        floyd(n, matrix);

        // 처음부터 따로가는 경우 계산
        ans = matrix[s][a] + matrix[s][b];
        // 경유지가 중간에 있는 경우 계산
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, matrix[s][i] + matrix[i][a] + matrix[i][b]);
        }
        return ans;
    }

    public void floyd(int n, int[][] matrix) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) matrix[i][j] = 0;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }
}