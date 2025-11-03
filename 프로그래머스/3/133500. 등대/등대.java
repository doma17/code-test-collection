import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        N = n;
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        light = new int[n + 1];
        
        for (int i = 0; i < lighthouse.length; i++) {
            int from = lighthouse[i][0];
            int to = lighthouse[i][1];
            
            list[from].add(to);
            list[to].add(from);
        }
        
        
        dfs(1, 0);
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (light[i] == 1) count++;
        }
        return count;
    }
    
    int N;
    ArrayList<Integer>[] list;
    int[] light;
    
    public int dfs(int cur, int parent) {
        if (list[cur].size() == 1 && list[cur].get(0) == parent) {
            // 자식이 단말노드이면 부모는 불을 켜야함
            return 1;
        }
            
        int count = 0;
        for (var next : list[cur]) {
            if (parent != next) {
                count += dfs(next, cur);
            }
        }
        // 자식 중 단말 노드가 있음
        if (count > 0) {
            light[cur] = 1;
            return 0;
        }
        return 1;
    }
}