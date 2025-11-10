class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int maxR = board.length;
        int maxC = board[0].length;
        int[][] sum = new int[maxR][maxC];
        
        for (var s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = (type == 1) ? -s[5] : s[5];
            
            sum[r1][c1] += degree;
            if (r2 + 1 < maxR) sum[r2 + 1][c1] += -degree;
            if (c2 + 1 < maxC) sum[r1][c2 + 1] += -degree;
            if (c2 + 1 < maxC && r2 + 1 < maxR) sum[r2 + 1][c2 + 1] += degree;
        }
        
        for (int r = 0; r < maxR; r++) {
            for (int c = 1; c < maxC; c++) {
                sum[r][c] += sum[r][c - 1];
            }
        }
        
        for (int c = 0; c < maxC; c++) {
            for (int r = 1; r < maxR; r++) {
                sum[r][c] += sum[r - 1][c];
            }
        }
        
        int cnt = 0;
        for (int r = 0; r < maxR; r++) {
            for (int c = 0; c < maxC; c++) {
                board[r][c] += sum[r][c];
                if (board[r][c] > 0) cnt++;
            }
        }
        return cnt;
    }
}