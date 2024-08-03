#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int main() {
    fastio;
    int N; int M;
    cin >> N >> M;
    vector<int> X(M+1);

    // 벡터에 가로등 사이의 거리를 입력한다.
    int a = 0; int b = 0;
    cin >> X[0];
    a = X[0];
    for(int i = 1; i < M; i++) {
        cin >> b;
        if((b - a) % 2 == 0) X[i] = (b - a)/2;
        // 홀 수인 경우를 생각해 밝기가 겹치게 만들어준다.
        else X[i] = (b - a + 1)/2;
        a = b;
    }
    // 마지막 굴다리 길이에서 마지막 가로등까지의 거리를 포함 시킨다.
    X[M] = N - b;
    sort(X.begin(), X.end());
    cout << X[M] << "\n";
}