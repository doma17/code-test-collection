#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int main() {
    fastio;
    priority_queue<int> max;
    priority_queue<int, vector<int>, greater<>> min;

    int N, input;
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> input;
        if(max.size() == min.size()) max.push(input);
        else min.push(input);
        
        if(!(max.empty() || min.empty()) && max.top() > min.top()) {
            int a = max.top();
            int b = min.top();
            max.pop();
            min.pop();
            max.push(b);
            min.push(a);
        }
        cout << max.top() << "\n";
    }
}