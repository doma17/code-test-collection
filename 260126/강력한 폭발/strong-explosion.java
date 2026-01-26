import java.util.*;
public class Main {

    static int[][] dr = {{-1, -2, 1, 2}, {-1, 1, 0, 0}, {-1, -1, 1, 1}};
    static int[][] dc = {{0, 0, 0, 0}, {0, 0, -1, 1}, {-1, 1, -1, 1}};

    static int n;
    static int answer = 0;
    static int[][] grid;

    static ArrayList<int[]> nodeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] != 0) {
                    map[i][j] = -1;
                    nodeList.add(new int[] {i, j});
                }
            }
        }
        
        dfs(map ,0);
        System.out.println(answer);
    }

    static void dfs(int[][] map, int idx) {
        if (idx == nodeList.size()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == -1)
                        count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        int[] loc = nodeList.get(idx);
        int r = loc[0];
        int c = loc[1];

        if (grid[r][c] != 0) {
            for (int i = 0; i < 3; i++) {
                int[][] tmp = new int[n][];
                for (int x = 0; x < n; x++)
                    tmp[x] = Arrays.copyOf(map[x], map[x].length);

                for (int x = 0; x < 4; x++) {
                    int nr = r + dr[i][x];
                    int nc = c + dc[i][x];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    tmp[nr][nc] = -1;
                }
                dfs(tmp, idx + 1);
            }
        }
    }
}