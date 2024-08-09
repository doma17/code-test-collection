#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
typedef long long int ll;
#define INF 987654321
#define MAX 300001

// 백준 1202번 문제
// https://www.acmicpc.net/problem/1202

// DEFINITION
int N, K;
pair<int, int> jewerly[MAX];
int bag[MAX];
priority_queue<int, vector<int>, less<int> > pq;
ll ans = 0;

int main() {
	fastio;
    // INPUT
    cin >> N >> K;
    for(int i = 0; i < N; i++) {
        cin >> jewerly[i].first >>  jewerly[i].second;
    }
    for(int i = 0; i < K; i++) {
        cin >> bag[i];
    }

    // PROCESS
    sort(jewerly, jewerly + N);
    sort(bag, bag + K);
    
    int idx = 0;
    for(int i = 0; i < K; i++) {
        while(idx < N && bag[i] >= jewerly[idx].first) {
            pq.push(jewerly[idx].second);
            idx++;
        }
        if(!pq.empty()) {
            ans += pq.top(); pq.pop();
        }
    }

    // OUTPUT
    cout << ans << "\n";

    return 0;
}