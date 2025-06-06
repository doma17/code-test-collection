import java.util.*;
import java.io.*;

class Solution {
    
    String[][] matrix;
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n, m, ans;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        
        ans = n * m;
        matrix = new String[n + 2][m + 2];
        visited = new boolean[n + 2][m + 2];
        
        for (var s : matrix) {
            Arrays.fill(s, "");    
        }
        
        for (int i = 0; i < n; i++) {
            String[] tmp = storage[i].split("");
            for (int j = 0; j < m; j++) {
                matrix[i + 1][j + 1] = tmp[j];
            }
        }
            
        for (var request : requests) {
            if (request.length() == 2) { // 크레인
                String target = request.split("")[0];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (matrix[i][j].equals(target)) {
                            matrix[i][j] = "";
                            ans--;
                        }
                    }
                }
            } else { // 지게차
                visited = new boolean[n + 2][m + 2];
                bfs(0, 0, request);
            }
        }
        
        return ans;
    }
    
    void bfs(int x, int y, String request) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int curX = node.x;
            int curY = node.y;
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextX <= m + 1 && nextY >= 0 && nextY <= n + 1) {
                    if (matrix[nextY][nextX].equals(request)) {
                        matrix[nextY][nextX] = "";
                        visited[nextY][nextX] = true;
                        ans--;
                    } else if (!visited[nextY][nextX] && matrix[nextY][nextX].equals("")) {
                        visited[nextY][nextX] = true;
                        q.add(new Node(nextX, nextY));
                    }
                }
            }
        }
    }
    
        class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}