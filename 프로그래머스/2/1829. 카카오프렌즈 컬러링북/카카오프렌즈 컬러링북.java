import java.util.*;

class Solution {
    
    private int M, N;
    private boolean[][] visited;
    private int[][] colors;
    
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, 1, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        colors = picture;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && picture[r][c] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(r, c));
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int bfs(int r, int c) {
        int size = 0;
        int color = colors[r][c];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int curR, curC;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            curR = tmp[0];
            curC = tmp[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + curR;
                int nc = dc[i] + curC;
                
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (color != colors[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
            size++;
        }
        return size;
    }
}