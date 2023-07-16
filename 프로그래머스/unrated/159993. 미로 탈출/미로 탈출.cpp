#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <string.h>
using namespace std;

queue<pair<int, int>> q;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int dist[101][101];
bool visited[101][101];
int N, M;

int bfs(vector<string> &maps, char target) {
    bool find = false; // target 확인변수
    int value = 99999999;
    for(int i=0; i<101; i++){ // 배열 0으로 초기화
        memset(dist[i], 0, sizeof(int)*101); 
        memset(visited[i], 0, sizeof(bool)*101);
    }
    
    while(!q.empty()) {
        auto tmp = q.front(); q.pop();
        int x = tmp.first;
        int y = tmp.second;
        int cnt = dist[x][y];
        
        if(maps[x][y] == target) { // target을 찾았을때
            value = min(value, cnt);
            find = true;
        }
        
        for(int i = 0; i < 4; i++) {
            int dir_x = x + dx[i];
            int dir_y = y + dy[i];
            if(visited[dir_x][dir_y] == true) // 이미 방문한 장소 제외
                continue;
            if(0 > dir_x || dir_x >= N || 0 > dir_y || dir_y >= M) // 배열 크기 제한
                continue;
            if(maps[dir_x][dir_y] == 'X') // 'X'는 벽으로 막힘
                continue;
            if(dist[dir_x][dir_y] == 0 || dist[dir_x][dir_y] > cnt + 1) { // 저장된 값이 0이거나 지금 들고 있는 값보다 작음
                q.push({dir_x, dir_y});
                dist[dir_x][dir_y] = cnt + 1;
                visited[dir_x][dir_y] = true;
            }
        }
    }
    if(find) // target을 찾으면 value 반환
        return value;
    return 0;
}

int solution(vector<string> maps) {
    int dist_exit, dist_lever;
    int lever_x, lever_y;
    
    N = maps.size();
    M = maps[0].size();
    
    for(int x = 0; x < N; x++) {
        for(int y = 0; y < M; y++) {
            if(maps[x][y] == 'S') {
                q.push({x, y});
            }   
            else if(maps[x][y] == 'L') {
                lever_x = x;
                lever_y = y;
            }
        }
    }
    // start to lever
    if(!(dist_lever = bfs(maps, 'L'))) // 레버로 가는 길이 없다면 종료
        return -1;
    
    // lever to end
    q.push({lever_x, lever_y}); // 저장 해놓은 레버 값 입력
    if(!(dist_exit = bfs(maps, 'E'))) // 탈출구로 가는 길이 없다면 종료
        return -1;
    
    // OUTPUT
    return dist_lever + dist_exit;;
}