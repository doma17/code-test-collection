#include <iostream>
#include <string>
#include <map>
#include <set>
#include <vector>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);

int main() {
    fastio;
    int N, M, P, L;
    cin >> N;

    multiset<pair<int, int>> ms;
    map<int, int> m; 
    for(int i = 0; i < N; i++) {
        cin >> P >> L;
        m[P] = L;
        ms.insert(make_pair(L, P));
    }

    cin >> M;
    string str;
    for(int i = 0; i < M; i++) {
        cin >> str;
        if(str == "add"){
            cin >> P >> L;
            m[P] = L;
            ms.insert(make_pair(L, P));
        }
        else if (str == "solved") {
            cin >> P;
            auto it = ms.find(make_pair(m[P], P));
            ms.erase(it);
            m.erase(P);
        }
        else { // recommend 명령어
            cin >> P;
            
            if(P == 1) {
                auto it = prev(ms.end());
                cout << it->second << "\n";
            }
            else {
                auto it = ms.begin();
                cout << it->second << "\n";
            }
        }
    }
}