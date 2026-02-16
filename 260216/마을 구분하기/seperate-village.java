import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;

    static ArrayList<Integer> peopleList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        visited = new boolean[n][n];
        int town = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == 0) continue;

                visited[i][j] = true;
                peopleList.add(dfs(i, j));
                town++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(town).append("\n");
        Collections.sort(peopleList);
        for (Integer x : peopleList) {
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    private static int dfs(int r, int c) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (visited[nr][nc]) continue;
            if (grid[nr][nc] == 0) continue;
            visited[nr][nc] = true;
            sum += dfs(nr, nc);
        }
        return sum + 1;
    }
}