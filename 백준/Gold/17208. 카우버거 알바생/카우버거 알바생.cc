#include <iostream>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int N, M, K;
int burger[301], fry[301];
// dp[주문수][치즈버거][감튀]
int dp[101][301][301];

int main() {
    fastio;
    // INPUT
    cin >> N >> M >> K;
    for(int i = 1; i <= N; i++)
        cin >> burger[i] >> fry[i];

    // DP
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            for(int x = 1; x <= K; x++) {
                // 현재 i인덱스의 주문에서 남은 버거, 감튀 개수보다 클 때
                if(j >= burger[i] && x >= fry[i])
                    dp[i][j][x] = max(dp[i-1][j][x], dp[i-1][j-burger[i]][x-fry[i]] + 1);
                else
                    dp[i][j][x] = dp[i-1][j][x];
            }
        }
    }
    // OUTPUT
    cout << dp[N][M][K] << "\n";
}