import java.util.*;

class Solution {

    int[][] dp, matrix;

    public int solution(int[][] matrix_sizes) {

        dp = new int[matrix_sizes.length + 1][matrix_sizes.length + 1];
        matrix = matrix_sizes;

        return recursion(0, matrix.length);
    }

    private int recursion(int start, int end) {
        if (start + 1 == end) return 0;

        int result = Integer.MAX_VALUE;

        for (int mid = start + 1; mid < end; ++mid) {
            int left = calcMatrix(start, mid);
            int right = calcMatrix(mid, end);
            int cnt = matrix[start][0] * matrix[mid][0] * matrix[end - 1][1];
            result = Math.min(result, left + right + cnt);
        }
        return result;
    }

    private int calcMatrix(int start, int end) {
        if (dp[start][end] == 0)
            dp[start][end] = recursion(start, end);
        return dp[start][end];
    }
}