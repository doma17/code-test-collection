import java.util.*;
import java.io.*;

public class Main {

    static class Pointer {
        int r, c;

        public Pointer(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 1, -1, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // N*N Stack
        ArrayList<Integer>[][] grid = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = new ArrayList<Integer>();
        }

        // value의 위치 저장
        Pointer[] loc = new Pointer[n * n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                grid[i][j].add(v);
                loc[v] = new Pointer(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int move = Integer.parseInt(st.nextToken());
            // move의 현재 위치
            Pointer p = loc[move];

            // 8 방향 탐색
            boolean canMove = false;
            int r = p.r;
            int c = p.c;
            int maxV = 0;
            for (int j = 0; j < 8; j++) {
                int nr = p.r + dr[j];
                int nc = p.c + dc[j];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (grid[nr][nc].isEmpty()) continue;
                
                for (Integer x : grid[nr][nc]) {
                    if (maxV < x) {
                        r = nr;
                        c = nc;
                        maxV = x;
                        canMove = true;
                    }
                }
            }

            // 주변이 모두 비어있거나, 못움직임
            if (!canMove) continue;

            // 위에 부분 임시 저장
            Stack<Integer> temp = new Stack<>();
            while (grid[p.r][p.c].get(grid[p.r][p.c].size() - 1) != move && !grid[p.r][p.c].isEmpty()) {
                temp.add(grid[p.r][p.c].remove(grid[p.r][p.c].size() - 1));
            }
            temp.add(grid[p.r][p.c].remove(grid[p.r][p.c].size() - 1));

            // System.out.println(m + " " + move + " : " + temp.size() + " " + temp.get(temp.size() - 1) + ", " + p.r + " " + p.c + " / " + r + " " + c);

            // Pointer(위치값) 변경 이후 r, c에 다 넣기 
            for (Integer x : temp) { 
                loc[x] = new Pointer(r, c);
            }

            while (!temp.isEmpty()) {
                grid[r][c].add(temp.pop());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].isEmpty()) sb.append("None\n");
                else {
                    for (int k = grid[i][j].size() - 1; k >= 0; k--) 
                        sb.append(grid[i][j].get(k)).append(" ");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}