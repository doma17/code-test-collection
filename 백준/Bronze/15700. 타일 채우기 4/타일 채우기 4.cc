#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int main() {
    fastio;
    // 1 ≤ N, M ≤ 1,000,000,000 이기 때문에 long long int로 설정
    long long int N, M;
    cin >> N >> M;
    // N x M의 타일에서 2개의 칸을 차지하는 1x2, 2x1 타일이 들어 갈 수 있는
    // 최대 갯수는 N * M / 2 이다.
    cout << N * M / 2 << "\n";
}