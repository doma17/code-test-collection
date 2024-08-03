#include <iostream>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

// 참조:https://gsmesie692.tistory.com/113
int N, K;
int caffeine[101];
int dp[101][100001] = {0};

int main() {
    fastio;
    // INPUT
    cin >> N >> K;
    for(int i = 1; i <= N; i++)
        cin >> caffeine[i];

    // DP
    for(int i = 0; i <= N; i++) {
        for(int j = 1; j <= K; j++) {
            if(i == 0) // 최솟값을 찾는 과정이기 때문에 초기값을 최대값으로 설정한다.
                dp[i][j] = (int)1e9;
            else if(j >= caffeine[i]) // j - caffeine[i] >= 0과 같다.
                // 경우의 수를 찾는 것이기 때문에 +1해준다.
                dp[i][j] = min(dp[i-1][j], dp[i-1][j - caffeine[i]] + 1); 
            else
                dp[i][j] = dp[i-1][j];
        }
    }

    // OUTPUT
    if(dp[N][K] == (int)1e9) cout << "-1\n";
    else cout << dp[N][K] << "\n";
}