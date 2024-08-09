#include <iostream>
#include <vector>
#include <tuple>
#include <math.h>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define INF 987654321
typedef long long int ll;

// 백준 2887번 문제
// 최소 신장 트리 문제 - 유니온 파인드 알고리즘

int n;
int x, y, z;
vector<pair<int, int>> X;
vector<pair<int, int>> Y;
vector<pair<int, int>> Z;

vector<tuple<int, int, int>> edge; // {cost, node1, node2}
int parent[100001];
ll ans;

int find(int x) {
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

// 같은 컴포넌트가 있는지 확인하는 함수
bool same(int x, int y) {
    x = find(x);
    y = find(y);
    if(x == y) return false;
    else {
        parent[x] = y;
        return true;
    }
}

void union_find() {
    for(int i = 0; i < n; i++) {
        parent[i] = i;
    }

    int a, b, c;
    for(auto e : edge) {
        tie(c, a, b) = e;
        
        if(same(a, b))
            ans += c;
    }
}

int main() {
	fastio;
    
    // INPUT
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> x >> y >> z;
        X.push_back({x, i});
        Y.push_back({y, i});
        Z.push_back({z, i});
    }

    sort(X.begin(), X.end());
    sort(Y.begin(), Y.end());
    sort(Z.begin(), Z.end());

    for(int i = 0; i < n-1; i++) {
        edge.push_back({abs(X[i].first - X[i + 1].first), X[i].second, X[i + 1].second});
        edge.push_back({abs(Y[i].first - Y[i + 1].first), Y[i].second, Y[i + 1].second});
        edge.push_back({abs(Z[i].first - Z[i + 1].first), Z[i].second, Z[i + 1].second});
    }

    sort(edge.begin(), edge.end());
    union_find();

    // OUTPUT
    cout << ans << "\n";
}