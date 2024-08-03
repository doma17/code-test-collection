#include <iostream>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int n, k;
int value[1001], cost[1001];
// dp[과목수][중요도]
int dp[1000][10000] = {0};

int main() {
    fastio;

    cin >> n >> k;
    for(int i = 1; i <= k; i++)
        cin >> value[i] >> cost[i];
    
    int ans = 0;
    for(int i = 1; i <= k; i++) {
        for(int j = 1; j <= n; j++) {
            // 이전 과목에서의 중요도 최댓값을 현재 과목에 더해서 나타낸다.
            // 과목수 배열 없이 나타낸다면 첫번째 과목에서 중복이 나타나 1300이라는 값이 입력될 수 있다.
            if(j - cost[i] >= 0)
                dp[i][j] = max(dp[i-1][j], dp[i-1][j - cost[i]] + value[i]);
            else
                dp[i][j] = dp[i-1][j]; 
            ans = max(ans, dp[i][j]);
        }
    }
    
    cout << ans << "\n";
}