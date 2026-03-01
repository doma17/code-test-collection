import java.util.*;

public class Main {

    static int n, h, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 2)
                    list.add(new int[] {i, j});
            }
        }
        
        int[][] result = new int[n][n];
        for (int[] human : list) {
            result[humna[0]][human[1]] = bfs(human[0], human[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(result[i][j] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int r, int c) {
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        boolean[][] visited = new boolean[n][n];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] next = q.poll();
            
            for ()
        }
    }
}