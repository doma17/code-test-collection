import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int wanhoSum = scores[0][0] + scores[0][1];
        int[] wanho = scores[0];
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        
        int maxY = -1;
        int sumCnt = 0;
        boolean fail = false;
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < maxY) {
                if (scores[i][0] == wanho[0] && scores[i][1] == wanho[1]) {
                    fail = true;
                    break;
                }
                continue;
            }
            
            maxY = Math.max(maxY, scores[i][1]);
            if (scores[i][0] + scores[i][1] > wanhoSum) sumCnt++;
        }
        
        if (fail) return -1;
        return sumCnt + 1;
    }
}