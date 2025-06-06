import java.util.*;
import java.io.*;

class Solution {
    
    ArrayList<Integer> list = new ArrayList<>();
    int n;
    int[][] q;
    int[] ans;
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        dfs(1, 0);
        
        return answer;
    }
    
    public void dfs(int cur, int cnt) {
        // 길이가 5일때
        if (cnt == 5) {
            if (isAns()) {
                answer++;
            }
        }
        
        // 모든 1 ~ N까지의 조합 백트래킹
        for (int i = cur; i <= n; i++) {
            list.add(i);
            dfs(i + 1, cnt + 1);
            list.remove(list.size() - 1);
        }
    }
    
    /**
    * 현재 list의 조합이 q와 일치하는지 탐색
    */
    public boolean isAns() {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < q[i].length; j++) {
                for (var x : list) {
                    if (x == q[i][j]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt != ans[i]) {
                return false;
            }
        }
        return true;
    }
}