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

void dfs(int cnt, int index) {
    if(cnt == m) {
        for(int i = 0; i < m; i++) cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    int temp = 0;
    for(int i = index; i < n; i++) {
        if(!visited[i] && input[i] != temp) { 
            visited[i] = true;               
            arr[cnt] = input[i];
            temp = arr[cnt];
            dfs(cnt + 1, i + 1);
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
    dfs(0, 0);
}