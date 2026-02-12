import java.util.*;

public class Main {

    static int n;
    static int[][] cost;
    static boolean[] visited;

    static int answer = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n];
        choose(0, 0, 0);
        System.out.println(answer);
    }

    private static void choose(int idx, int sum, int spot) {
        if (idx == n) {
            if (spot == 0) answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (cost[spot][i] == 0) continue;
            visited[i] = true;
            choose(idx + 1, sum + cost[spot][i], i);
            visited[i] = false;
        }
    }
}