import java.util.*;

class Solution {
    
    static final int INF = 1_000_000_000;
    
    public int solution(int alp, int cop, int[][] problems) {
        
        int maxAlp = 0;
        int maxCop = 0;
        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }
        
        if (alp >= maxAlp && cop >= maxCop) return 0;
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) 
            Arrays.fill(dp[i], INF);
        
        dp[alp][cop] = 0;
        for (int a = alp; a <= maxAlp; a++) {
            for (int c = cop; c <= maxCop; c++) {
                if (dp[a][c] == INF) continue;
                if (a < maxAlp) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                }
                if (c < maxCop) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                }
                
                for (int[] p : problems) {
                    // 문제 풀이 (중복 풀이 가능)
                    if (a >= p[0] && c >= p[1]) {
                        int na = Math.min(maxAlp, a + p[2]);
                        int nc = Math.min(maxCop, c + p[3]);
                        dp[na][nc] = Math.min(dp[na][nc], dp[a][c] + p[4]);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}
