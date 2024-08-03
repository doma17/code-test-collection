#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
typedef long long int ll;

int main() {
    fastio;
    int T, n, MOD = 1000000009;
    cin >> T;

    priority_queue<ll> q;
    vector<ll> v;
    while(T--) {
        cin >> n;
        q.push(n);
        v.push_back(n);
    }

    ll dp[q.top() + 1];
    dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;
    for(int i = 4; i <= q.top(); i++) dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
    for(auto x : v) cout << dp[x] % MOD << "\n";
}