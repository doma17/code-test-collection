#include <string>
#include <vector>
#include <queue>
using namespace std;

int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
bool visited[104][104];
queue<vector<int>> q;

int solution(vector<string> board) {
    int answer = -1;
    
    int n = board.size();
    int m = board[0].size();
    
    for(int i=0; i<board.size(); i++){
        for(int j=0; j<board[i].size(); j++){
            if(board[i][j] == 'R') {
                q.push({i,j,1});
                visited[i][j] = 1;
            }
        }
    }
    
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        int y = cur[0];
        int x = cur[1];
        int dist = cur[2];
        
        if(board[y][x] == 'G'){
            return dist - 1;
        }
        
        for(int dir=0; dir<4; dir++){
            int nx = x;
            int ny = y;
            while(1) {
                nx += dx[dir];
                ny += dy[dir];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    nx -= dx[dir];
                    ny -= dy[dir];
                    break;
                }
                if(0 <= nx && nx < m && 0 <= ny && ny < n && board[ny][nx] == 'D'){
                    nx -= dx[dir];
                    ny -= dy[dir];
                    break;
                }
                
            }
            if(visited[ny][nx] == 0){
                visited[ny][nx] = 1;
                q.push({ny,nx, dist + 1});
            }
        }
    }
    return -1;
}