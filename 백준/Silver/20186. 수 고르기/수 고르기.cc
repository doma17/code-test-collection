#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int main() {
    fastio;
    int N; int K;
    cin >> N >> K;
    vector<int> v(N);
    for(int i = 0; i < N; i++) cin >> v[i];
    sort(v.begin(), v.end());
    
    int sum = 0;
    for(int i = N-K; i < N; i++) sum += v[i];
    for(int i = 0; i < K; i++) sum -= i;
    cout << sum << "\n";
}