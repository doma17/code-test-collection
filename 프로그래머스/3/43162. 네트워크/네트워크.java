class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int cur, int n, int[][] computers) {
        visited[cur] = true;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && computers[cur][i] == 1) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}