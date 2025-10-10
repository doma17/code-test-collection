import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int maxX = park[0].length();
        int maxY = park.length;
        int startX = 0, startY = 0;
        int curX = 0, curY = 0;
        
        char[][] map = new char[maxY][maxX];
        
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = j;
                    startY = i;
                }
                map[i][j] = park[i].charAt(j);
            }
        }
        
        for (var m : map) {
            for(var x : m) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
        Map<String, int[]> dir = Map.of(
            "E", new int[] {0, 1},
            "W", new int[] {0, -1},
            "S", new int[] {1, 0},
            "N", new int[] {-1, 0}
        );
        
        curX = startX;
        curY = startY;
        for (int i = 0; i < routes.length; i++) {
            String d = routes[i].split(" ")[0];
            int dist = Integer.parseInt(routes[i].split(" ")[1]);
            
            // 방향 선택
            int[] move = dir.get(d);
            int dx = move[1];
            int dy = move[0];  
            
            int nextX = curX;
            int nextY = curY;

            boolean valid = true;
            for (int k = 0; k < dist; k++) {
                nextX += dx;
                nextY += dy;
                
                if (nextX < 0 || nextY < 0 || nextX >= maxX || nextY >= maxY) {
                    valid = false;
                    break;
                } else if (map[nextY][nextX] == 'X') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                curX = nextX;
                curY = nextY;
            }
        }
        
        return new int[] {curY, curX};
    }
}