import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[] visited;

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n];
        choose(0, 10001);
        System.out.println(answer);
    }

    private static void choose(int num, int minValue) {
        if (num == n) {
            answer = Math.max(answer, minValue);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            choose(num + 1, Math.min(minValue, grid[num][i]));
            visited[i] = false;
        }
    }
}