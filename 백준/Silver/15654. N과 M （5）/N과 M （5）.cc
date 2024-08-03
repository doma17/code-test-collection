#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define ll long long int

int n, m;
int arr[9] = {0};
bool visited[9] = {0};
vector<int> input;

void dfs(int cnt) {
    if(cnt == m) {
        for(int i = 0; i < m; i++) cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for(int i = 0; i < n; i++) {
        if(!visited[i]) {
            visited[i] = true; // 방문 확인
            arr[cnt] = input[i];
            dfs(cnt + 1);
            visited[i] = false;
        }
    }
}

int main() {
    fastio;
    cin >> n >> m;
    input.resize(n);
    for(int i = 0; i < n; i++)
        cin >> input[i];
    sort(input.begin(), input.end());
    dfs(0);
}