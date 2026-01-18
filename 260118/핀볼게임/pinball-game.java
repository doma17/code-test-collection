import java.util.*;
public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        // 0 빈칸, 1 '/' 모양, 2 '\' 모양
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        ArrayList<Point> startPointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            startPointList.add(new Point(0, i, 1));
            startPointList.add(new Point(n - 1, i, 0));
            startPointList.add(new Point(i, n - 1, 2));
            startPointList.add(new Point(i, 0, 3));
        }

        int maxTime = 0;
        for (Point p : startPointList) {
            int time = 1;

            int d = p.dir;
            int r = p.r;
            int c = p.c;

            while (true) {
                time++;
                if (grid[r][c] != 0) {
                    d = switchDir(d, grid[r][c]);
                }

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) break;

                r = nr;
                c = nc;
            }
            // System.out.println(maxTime + " " + time + " " + p.r + " " + p.c + " " + p.dir);
            maxTime = Math.max(maxTime, time);
        }
        System.out.println(maxTime);
    }

    private static int switchDir(int dir, int shape) {
        if (dir == 0) {
            return shape == 1 ? 3 : 2;
        } else if (dir == 1) {
            return shape == 1 ? 2 : 3;
        } else if (dir == 2) {
            return shape == 1 ? 1 : 0;
        } else {
            return shape == 1 ? 0 : 1;
        }
    }

    static class Point {
        int r, c;
        int dir;

        public Point(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}