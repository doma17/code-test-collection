#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define INF 987654321

// 백준 114041번 문제
// 플로이드-워셜 알고리즘 문제

int n, m;
int a, b, c;
int dist[101][101];
int route[101][101];
vector<int> v;

void floyd_warshall() {
    for(int k = 1; k <= n; k++) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(dist[i][k] == INF || dist[k][j] == INF) continue;

                if(dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    route[i][j] = k;
                }
            }
        }
    }
}

void find_route(int start, int end) {
    if (route[start][end] == 0) {
        v.push_back(start);
        v.push_back(end);
        return;
    }
    find_route(start, route[start][end]);
    v.pop_back();
    find_route(route[start][end], end);
}

int main() {
	fastio;
    // INPUT
    cin >> n >> m;
    for(int i = 0; i <= n; i++) {
        for(int j = 0; j <=n; j++) {
            dist[i][j] = INF;        
        }
    }
    for(int i = 0; i < m; i++) {
        cin >> a >> b >> c;
        dist[a][b] = min(dist[a][b], c);
    }

    floyd_warshall();

    // OUTPUT
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if (dist[i][j] == INF) cout << 0 << " ";
            else cout << dist[i][j] << " ";
        }
        cout << "\n";
    }
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            if (dist[i][j] == INF) cout << 0;
            else {
                v.clear();
                find_route(i, j);
                cout << v.size() << " ";
                for(auto x : v) 
                    cout << x << " ";
            }
            cout << "\n";
        }
    }
}