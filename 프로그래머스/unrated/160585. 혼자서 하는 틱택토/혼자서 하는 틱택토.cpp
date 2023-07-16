#include <string>
#include <vector>

using namespace std;

int findComplete(char letter, vector<string> &board) {
    // 직선방향
    for(int i = 0; i < 3; i++) {
        if(board[i][0] == letter && board[i][1] == letter && board[i][2] == letter)
            return 1;
        if(board[0][i] == letter && board[1][i] == letter && board[2][i] == letter)
            return 1;
    }
    
    // 대각선 방향
    if(board[0][0] == letter && board[1][1] == letter && board[2][2] == letter)
        return 1;
    if(board[0][2] == letter && board[1][1] == letter && board[2][0] == letter)
        return 1;
    
    return 0;
}

int solution(vector<string> board) {
    int answer = 1;
    
    bool x_comp = findComplete('X', board);
    bool o_comp = findComplete('O', board);
    
    int x_cnt = 0, o_cnt = 0;
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            if(board[i][j] == 'X')
                x_cnt++;
            else if(board[i][j] == 'O')
                o_cnt++;
        }
    }
    
    if(x_cnt > o_cnt || x_cnt + 2 <= o_cnt || (x_comp && o_comp) || (x_comp && o_cnt > x_cnt) || (o_comp && o_cnt == x_cnt))
        return 0;
    else
        return 1;
}