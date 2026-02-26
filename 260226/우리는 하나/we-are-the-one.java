import java.util.*;

public class Main {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int n, k, u, d;
    static int[][] grid;

    static List<int[]> cityList = new ArrayList<>();
    static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        chooseCity(0, 0);
        System.out.println(answer);
    }

    private static void chooseCity(int num, int idx) {
        if (num == k) {
            answer = Math.max(answer, bfs());
            return;
        }

        for (int i = idx; i < n * n; i++) {
            int r = i / n;
            int c = i % n;

            cityList.add(new int[] {r, c});
            chooseCity(num + 1, i + 1);
            cityList.remove(cityList.size() - 1);
        }
    }

    private static int bfs() {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (int[] city : cityList) {
            q.add(new int[] {city[0], city[1]});
            visited[city[0]][city[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] city = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = city[0] + dr[i];
                int nc = city[1] + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;

                int diff = Math.abs(grid[nr][nc] - grid[city[0]][city[1]]);
                if (diff >= u && diff <= d) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
            count++;
        }
        return count;
    }
}