import java.util.*;
public class Main {

    static int n;
    static int[][] grid;
    static boolean[] visited;

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        choose(0, 0);
        System.out.println(answer);
    }

    private static void choose(int num, int sum) {
        if (num == n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            choose(num + 1, sum + grid[num][i]);
            visited[i] = false;
        }
    }
}