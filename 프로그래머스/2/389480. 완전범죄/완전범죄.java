import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        int[][] dp = new int[itemCount + 1][m];
        for (int i = 0; i <= itemCount; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 0; i < itemCount; i++) {
            int aCost = info[i][0];
            int bCost = info[i][1];
            for (int bSum = 0; bSum < m; bSum++) {
                if (dp[i][bSum] == Integer.MAX_VALUE) continue;
                // A 도둑이 훔침
                if (dp[i][bSum] + aCost < n) {
                    dp[i + 1][bSum] = Math.min(dp[i + 1][bSum], dp[i][bSum] + aCost);
                }
                // B 도둑이 훔침
                if (bSum + bCost < m) {
                    dp[i + 1][bSum + bCost] = Math.min(dp[i + 1][bSum + bCost], dp[i][bSum]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int bSum = 0; bSum < m; bSum++) {
            if (dp[itemCount][bSum] < n) {
                answer = Math.min(answer, dp[itemCount][bSum]);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}