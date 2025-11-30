import java.util.*;

class Solution {
    
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return dfs(aloc, bloc, true, board);
    }
    
    private int dfs(int[] aloc, int[] bloc, boolean turn, int[][] board) {
        int r = turn ? aloc[0] : bloc[0];
        int c = turn ? aloc[1] : bloc[1];
        
        if (board[r][c] == 0) return 0;
        
        ArrayList<Integer> winSteps = new ArrayList<>();
        ArrayList<Integer> loseSteps = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            
            if (nextR < 0 || nextR >= board.length || nextC < 0 || nextC >= board[0].length) continue;
            if (board[nextR][nextC] == 0) continue;
            
            board[r][c] = 0;
            
            int val = 0;
            if (turn) {
                val = dfs(new int[]{nextR, nextC}, bloc, !turn, board);
            } else {
                val = dfs(aloc, new int[]{nextR, nextC}, !turn, board);
            }
            
            board[r][c] = 1;
            
            if (val % 2 == 0) {
                winSteps.add(val + 1);
            } else {
                loseSteps.add(val + 1);
            }
        }
        
        // 이길수 있는 경우가 있다면 가장 빠르게 이기는법으로
        if (!winSteps.isEmpty()) return Collections.min(winSteps);
        // 무조건 지게 된다면 게임을 최대한 오래 버티도록
        if (!loseSteps.isEmpty()) return Collections.max(loseSteps);
        
        return 0;
    }
}

// import java.util.*;

// class Solution {
//     public int solution(int[][] board, int[] aloc, int[] bloc) {
//         dfs(0, true, aloc, bloc, board);
//         return maxCount;
//     }
    
//     int[] dr = {1, -1, 0, 0};
//     int[] dc = {0, 0, 1, -1};
    
//     int maxCount = 0;
    
//     // turn이 true일때 A플레이어, false일때 B플레이어 - A플레이어 먼저 시작
//     private void dfs(int count, boolean turn, int[] aloc, int[] bloc, int[][] board) {
//         maxCount = Math.max(maxCount, count);
        
        
         
//         for (int i = 0; i < 4; i++) {
//             int nextR = (turn) ? aloc[0] + dr[i] : bloc[0] + dr[i];
//             int nextC = (turn) ? aloc[1] + dc[i] : bloc[1] + dc[i];
            
//             if (0 > nextR || nextR >= board.length || 0 > nextC || nextC >= board[0].length) continue;
//             if (board[nextR][nextC] == 0) continue;
            
//             int[] nextLoc = {nextR, nextC};
            
//             // 밟았던 발판 삭제
//             if (turn) board[aloc[0]][aloc[1]] = 0;
//             else board[bloc[0]][bloc[1]] = 0;
            
//             if (turn) { // A 플레이어
//                 dfs(count + 1, !turn, nextLoc, bloc, board);
//             } else { // B 플레이어
//                 dfs(count + 1, !turn, aloc, nextLoc, board);
//             }

//             if (turn) board[aloc[0]][aloc[1]] = 1;
//             else board[bloc[0]][bloc[1]] = 1;
//         }
//     }
// }

