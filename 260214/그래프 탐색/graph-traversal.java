import java.util.*;

public class Main {

    static int n, m;

    static ArrayList<Integer>[] vertex;
    static boolean[] visited;

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        vertex = new ArrayList[n];
        for (int i = 0; i < n; i++)
            vertex[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            vertex[u].add(v);
            vertex[v].add(u);
        }
        
        visited = new boolean[n];
        visited[0] = true;
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int idx) {
        for (Integer x : vertex[idx]) {
            if (visited[x]) continue;
            visited[x] = true;
            dfs(x);
            count++;
        }
    }
}