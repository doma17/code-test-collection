#include <iostream>
#include <vector>
#include <math.h>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int main() {
    fastio;

    int N; int M;
    cin >> N >> M;

    vector<int> A(N);
    vector<int> D(M);
    for(int i = 0; i < N; i++) cin >> A[i];
    for(int i = 0; i < M; i++) cin >> D[i];
    sort(A.begin(), A.end());

    // M개의 질문을 대답한다.
    for(int i = 0; i < M; i++) {
        int left = 0; int right = N-1; int mid;
        // 정답 값을 -1로 초기화한다.
        int ans = -1;

        // 이진탐색을 통해서 값의 위치를 찾는다.
        while(left <= right) {
            mid = (left + right) / 2;
            if(A[mid] > D[i]) right = mid - 1;
            else left = mid + 1;
            
            // 탐색에 실패하면 ans는 -1이 그대로 남아있다.
            if(A[mid] == D[i]) {
                ans = mid;
                break;
            }
        }
        // 중복되는 수가 여러개 일 경우를 위해 같은 value의 가장 작은 index를 찾는다.
        if(ans != -1) {
            left = 0; right = ans;

            // 이진탐색
            while(left <= right) {
                mid = (left + right) / 2;

                if(A[mid] == A[ans]) {
                    right = mid - 1;

                    // A[mid - 1]과 A[ans]이 다른 가장앞의 인덱스 mid
                    if(A[mid - 1] != A[ans]) {
                        ans = mid;
                        break;
                    }
                }
                else left = mid + 1;
            }
        }
        cout << ans << "\n";
    }
}