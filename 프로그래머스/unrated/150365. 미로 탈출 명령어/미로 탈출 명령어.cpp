// #include <string>
// #include <vector>
// #include <queue>
// #include <iostream>
// #include <cmath>
// #include <algorithm>
// using namespace std;

// int dy[] = {1, 0, 0, -1};
// int dx[] = {0, -1, 1, 0};
// string ds[] = {"d", "l", "r", "u"};
// queue<pair<string, pair<int, int>>> q;
// vector<string> v;
// int s_x, s_y;

// void bfs(int n, int m, int r, int c, int k) {
//     while(!q.empty()) {
//         auto cnt = q.front(); q.pop();
//         string cnt_str = cnt.first;
//         int cnt_x = cnt.second.first;
//         int cnt_y = cnt.second.second;
        
//         // 현재 위치에서 목표지점까지의 거리
//         int dist = abs(cnt_x - r) + abs(cnt_y - c);
        
//         // 완전히 탐색하기 때문에 경우의 수가 너무 많음으로
//         // 가지치기 방법을 탐구해야 될듯함.
//         if(k - cnt_str.size() - dist < 0)
//             continue;
//         if((k - cnt_str.size() - dist) % 2 == 1)
//             continue;
        
//         if(cnt_str.size() == k) {
//             if(cnt_x == c && cnt_y == r)
//                 v.push_back(cnt_str);
//         }
//         else {
//             for(int dir = 0; dir < 4; dir++) {
//                 int x = cnt_x + dx[dir];
//                 int y = cnt_y + dy[dir];                

//                 if(0 < x && x <= m && 0 < y && y <= n) {
//                     string str = cnt_str + ds[dir];
//                     q.push({str ,{x, y}});
//                 }
//             }
//         }
//     }
// }

// string solution(int n, int m, int x, int y, int r, int c, int k) {
//     s_x = x;
//     s_y = y;
    
//     q.push({"", {y, x}});
//     bfs(n, m, r, c, k);
    
//     sort(v.begin(), v.end());
    
//     if(v.empty()) return "impossible";
//     else return v[0];
// }

#include <string>
#include <vector>
#include <cmath>
#include <iostream>
using namespace std;
string answer = "";
string ret = "impossible";
bool flag = false;

int n,m,x,y,r,c,k;
int dx[4] = {1,0,0,-1};
int dy[4] = {0,-1,1,0};
char dir[4] = {'d','l','r','u'};
int get_dist(int x,int y,int a,int b){
    return abs(x-a) + abs(y-b);
}

void dfs(int cnt,int curx,int cury){
    if(!flag){
        
        int dist = get_dist(curx,cury,r,c);
        if(k - cnt - dist < 0) return;
        if((k - cnt - dist) % 2 == 1 ) return;

        if(cnt == k){
            if(curx == r && cury == c){
                flag = true;
                ret = answer;
            }
            return ;
        }
        for(int k = 0 ;k < 4 ;k++){
            int newx = curx + dx[k];
            int newy = cury + dy[k];
            if(newx > 0 && newx <= n && newy > 0 && newy <= m){
                answer += dir[k];
                dfs(cnt + 1, newx, newy);
                answer.pop_back();
            }
        }
    }
}

string solution(int _n, int _m, int _x, int _y, int _r, int _c, int _k) {
    n = _n; m = _m ; x = _x; y = _y; r = _r; c = _c; k= _k;
    dfs(0,x,y);
    return ret;
}