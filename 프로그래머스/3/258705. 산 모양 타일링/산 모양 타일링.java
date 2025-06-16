class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = tops[0] == 1 ? 4 : 3;
        
        for (int i = 2; i <= n; i++) {
            int x = tops[i - 1] == 1 ? 4 : 3;
            dp[i] = (dp[i - 1] * x - dp[i - 2] + 10007) % 10007;
        }
        return dp[n];
    }
}