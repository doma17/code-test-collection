import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        int answer = 0;
        int curX = 5;
        int curY = 5;
        
        boolean[][][] visited = new boolean[11][11][4];
        
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nextX = curX;
            int nextY = curY;
            int dirIndex = 0;
            int reverseDirIndex = 0;
            
            if (dir == 'U') {
                nextY++;
                dirIndex = 0;
                reverseDirIndex = 1;
            } else if (dir == 'D') {
                nextY--;
                dirIndex = 1;
                reverseDirIndex = 0;
            } else if (dir == 'R') {
                nextX++;
                dirIndex = 2;
                reverseDirIndex = 3;
            } else if (dir == 'L') {
                nextX--;
                dirIndex = 3;
                reverseDirIndex = 2;
            }
            
            if (nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10) {
                continue;
            }
            
            if (!visited[curY][curX][dirIndex]) {
                answer++;
                visited[curY][curX][dirIndex] = true;
                visited[nextY][nextX][reverseDirIndex] = true;
            }
            
            curX = nextX;
            curY = nextY;
        }
        
        return answer;
    }
}