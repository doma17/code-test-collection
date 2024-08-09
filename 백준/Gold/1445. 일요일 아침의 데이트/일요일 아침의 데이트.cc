#include <iostream>
#include <vector>
#include <string.h>
#include <queue>
#include <string>
#include <algorithm>
using namespace std;
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define INF 100000
typedef long long int ll;

// 백준 1445번 문제
// 이 문제는 음의 가중치가 존재하지 않기 때문에 다익스트라 알고리즘을 활용해야 하는 문제라고 분석했다.
// 하지만 문제점이 쓰레기를 싫어하는 우선순위에 있었다. 쓰레기 옆을 지나가는 횟수가 아무리 많더라고 해도 쓰레기 노드를 직접
// 지나가는 것보다 우선순위가 낮기 때문에 두 개의 cost를 따로 계산하여 우선순위를 설정해줘야 된다는 점이 어려운 점이었다.

int N, M;
int s_x, s_y;
int e_x, e_y;
int map[51][51];
int dist[51][51];
int x_weight[] = {1, 0, 0, -1};
int y_weight[] = {0, 1, -1, 0};
// 우선순위 큐의 비교 연산자 구현
// 참조: https://hydroponicglass.tistory.com/entry/C-STL-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-%ED%81%90priority-queue-%EB%B9%84%EA%B5%90%EC%97%B0%EC%82%B0%EC%9E%90-%EA%B5%AC%ED%98%84
// pair<pair<int, int>, pair<int, int>>
// {{쓰레기 노드를 만남, 쓰레기 노드 옆을 지나감}, {y좌표, x좌표}}
priority_queue<pair<pair<int, int>, pair<int, int>>, vector<pair<pair<int, int>, pair<int,int>>>, greater<pair<pair<int, int>, pair<int,int>>>>pq;

void dijkstra() {
    // 전처리
    pq.push({{0, 0}, {s_y, s_x}});
    memset(dist, -1, sizeof(dist));
    dist[s_y][s_x] = 0;

    while (!pq.empty())
    {
        int trash = pq.top().first.first;
        int beside = pq.top().first.second;
        int y = pq.top().second.first;
        int x = pq.top().second.second;
        pq.pop();

        for(int k = 0; k < 4; k++) {
            int ny = y + y_weight[k];
            int nx = x + x_weight[k];

            // 도착 노드에 도착 했을때 출력 및 종료.
            if(ny == e_y && nx == e_x) {
                cout << trash << " " << beside << "\n";
                exit(0);
            }
            if(ny < 0 || ny >= N || nx < 0 || nx >= M ) continue; // 범위 지정
            if(dist[ny][nx] != -1) continue; // 아직 도달하지 않은 노드
            // 쓰레기 노드를 지나갈 때
            if(map[ny][nx] == INF) {
                pq.push({{trash + 1, beside}, {ny, nx}});
            }
            // 쓰레기 노드 옆을 지나갈 때
            else if(map[ny][nx] == 1) {
                pq.push({{trash, beside + 1}, {ny, nx}});
            }
            // 쓰레기 X
            else {
                pq.push({{trash, beside}, {ny, nx}});
            }
            dist[ny][nx] = dist[y][x] + 1;
        }
    }
}

int main() {
	fastio;
    cin >> N >> M;

    string input;
    for(int i = 0; i < N; i++) {
        cin >> input;
        for(int j = 0; j < M; j++) {
            if(input[j] == '.') map[i][j] = 0;
            else if(input[j] == 'S') {
                // 출발노드
                s_x = j;
                s_y = i;
                map[i][j] = 0;
            }
            else if(input[j] == 'F') {
                // 도착노드
                e_x = j;
                e_y = i;
                map[i][j] = 0;
            }
            // 쓰레기 노드의 cost를 높게 책정
            else if(input[j] == 'g') {
                map[i][j] = INF;
            }
        }
    }
    // 쓰레기가 있는 주변 노드들의 cost를 1로 설정해준다.
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            if(map[i][j] != INF) continue;
            for(int k = 0; k < 4; k++) {
                int ny = i + y_weight[k];
                int nx = j + x_weight[k];

                if(map[ny][nx] == INF) continue;
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                map[ny][nx] = 1;
            }
        }
    }
    dijkstra();
}