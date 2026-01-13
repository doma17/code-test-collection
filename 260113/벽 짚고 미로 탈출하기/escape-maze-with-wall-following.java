import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        char[][] maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }
        
        int count = 0;
        int dir = 0;
        int curX = x;
        int curY = y;
        int[][] visitedCount = new int[n][n];

        while (true) {
            // 한 장소에 4번 이상 머무르면 무한 반복으로 간주
            visitedCount[curX][curY]++;
            if (visitedCount[curX][curY] > 4) {
                System.out.println(-1);
                return;
            }

            int rDir = (dir + 1) % 4;
            int rx = curX + dx[rDir];
            int ry = curY + dy[rDir];
            
            if (rx < 0 || rx >= n || ry < 0 || ry >= n) {
                count++;
                break;
            }

            // 오른쪽이 벽이 아님
            if (maze[rx][ry] != '#') {
                dir = rDir;
                curX = rx;
                curY = ry;
                count++;
            } else {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                // 탈출
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    count++;
                    break;
                }
                // 정면 전진 가능
                if (maze[nx][ny] != '#') {
                    curX = nx;
                    curY = ny;
                    count++;
                } else { // 정면이 벽
                    dir = (dir + 3) % 4;
                }
            }

        }

        System.out.println(count);
    }
}