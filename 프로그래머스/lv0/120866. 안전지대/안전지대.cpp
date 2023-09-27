#include <string>
#include <vector>

using namespace std;

int dx[] = {1, 1, 1, 0, 0, -1, -1, -1};
int dy[] = {1, 0, -1, 1, -1, 1, 0, -1};

int solution(vector<vector<int>> board) {
    int answer = board.size() * board.size();
    
    for(int i = 0; i < board.size(); i++) {
        for(int j = 0; j < board.size(); j++) {
            if(board[i][j] == 1) {
                for(int h = 0; h < 9; h++) {
                    if(0 > i + dy[h] || i + dy[h] >= board.size()) // i + dy가 배열에서 벗어날때
                        continue;
                    if(0 > j + dx[h] || j + dx[h] >= board.size()) // j + dx가 배열에서 벗어날때
                        continue;
                    if(board[i + dy[h]][j + dx[h]] == 0)
                        board[i + dy[h]][j + dx[h]] = 2;
                }
            }
        }
    }
    
    for(int i = 0; i < board.size(); i++) {
        for(int j = 0; j < board.size(); j++) { 
            if(board[i][j] > 0)
                answer--;
        }
    }
    
    return answer;
}