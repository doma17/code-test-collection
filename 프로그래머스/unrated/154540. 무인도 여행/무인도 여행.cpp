#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool visited[101][101];
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int len_x, len_y;

int dfs(int y, int x, vector<string> &maps) {
    int dist = (maps[y][x] - '0');
    visited[y][x] = true;
    
    for(int dir = 0; dir < 4; dir++) {
        int cnt_y = y + dy[dir];
        int cnt_x = x + dx[dir];
        
        if(0 > cnt_x || cnt_x >= len_x || 0 > cnt_y || cnt_y >= len_y)
            continue;
        if(maps[cnt_y][cnt_x] == 'X')
            continue;
        if(visited[cnt_y][cnt_x])
            continue;
        
        dist += dfs(cnt_y, cnt_x, maps);
    }
    
    return dist;
}

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    
    len_x = maps[0].size();
    len_y = maps.size();
    
    for(int i = 0; i < len_y; i++) {
        for(int j = 0; j < len_x; j++) {
            if(visited[i][j])
                continue;
            if(maps[i][j] == 'X')
                continue;
            answer.push_back(dfs(i, j, maps));
        }
    }
    
    if(answer.empty())
        answer.push_back(-1);
    sort(answer.begin(), answer.end());
    return answer;
}