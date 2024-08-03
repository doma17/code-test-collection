#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
typedef long long int ll;

int main() {
    fastio;
    int T, n; ll mod_num = 1000000009;
    cin >> T;
    vector<int> v;
    priority_queue<int> q;
    while(T--) {
        cin >> n;
        v.push_back(n);
        q.push(n);
    }
    
    ll dp[q.top() + 1][4];
    dp[0][1] = 1; dp[0][2] = 0; dp[0][3] = 0;
    dp[1][1] = 0; dp[1][2] = 1; dp[1][3] = 0;
    dp[2][1] = 1; dp[2][2] = 1; dp[2][3] = 1;
    for(int i = 3; i <= q.top(); i++) {
        dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod_num;
        dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod_num;
        dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod_num;
    }
    for(auto x : v) {
        cout << (dp[x-1][1] + dp[x-1][2] + dp[x-1][3]) % mod_num << "\n";
    }
}