import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int[][] dp = new int[onboard.length][51];
        for (int i = 0; i < onboard.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        // 온도 범위 보정 (-10 ~ 40 -> 0 ~ 50)
        temperature += 10;
        t1 += 10;
        t2 += 10;
        
        dp[0][temperature] = 0;
        for (int i = 0; i < onboard.length - 1; i++) {
            // -10도 ~ 40도
            for (int j = 0; j <= 50; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                
                // 온도를 높일때 최소비용
                if (j + 1 <= 50) {
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);
                }
                // 온도를 낮출 때 최소비용
                if (j - 1 >= 0) {
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                }
                // 온도 유지
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + b);
                
                int nextTemp = j;
                if (j < temperature) nextTemp++;
                else if (j > temperature) nextTemp--;
                
                dp[i+1][nextTemp] = Math.min(dp[i+1][nextTemp], dp[i][j]);
            }
            
            // 사람이 타 있을때 최적 온도 범위가 아니면 최대값으로 초기화
            if (onboard[i+1] == 1) {
                for (int j = 0; j <= 50; j++) {
                    if (j < t1 || j > t2) {
                        dp[i+1][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j <= 50; j++) {
            answer = Math.min(answer, dp[onboard.length - 1][j]);
        }
        
        return answer;
    }
}