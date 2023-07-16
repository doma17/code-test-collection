#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int x, int y, int n) {
    vector<int> dp(y + 1, 0);
    // 예외 x와 y가 같을때
    if(x == y) return 0;
    
    for(int i = x; i <= y; i++) {
        if(i == x || dp[i] != 0) {
            if(i + n <= y)
                dp[i + n] = (dp[i + n] != 0) ? min(dp[i + n], dp[i] + 1) : dp[i] + 1;
            if(i * 2 <= y)
                dp[i * 2] = (dp[i * 2] != 0) ? min(dp[i * 2], dp[i] + 1) : dp[i] + 1;
            if(i * 3 <= y)
                dp[i * 3] = (dp[i * 3] != 0) ? min(dp[i * 3], dp[i] + 1) : dp[i] + 1;
        }
            
    }
    
    if(dp[y] == 0) return -1;
    return dp[y];
}