import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int expansion = 0;
        int[] expandServer = new int[players.length];
        
        for (int i = 0; i < players.length; i++) {
            int nowPlayer = players[i];
            int cur = (expandServer[i] + 1) * m;
            
            if (nowPlayer >= cur) {
                int needed = nowPlayer - cur;
                int e = (needed + m) / m;
                
                for (int j = 0; j < k && (i + j) < players.length; j++) {
                    expandServer[i + j] += e;
                }
                expansion += e;
            }
        }
        return expansion;
    }
}