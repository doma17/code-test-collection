import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n;
    static ArrayList<Integer>[] list;

    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);

            list[x].add(y);
            list[y].add(x);
        }
        
        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        for (var next: list[start]) {
            if (!visited[next]) {
                parent[next] = start;
                dfs(next);
            }
        }
    }
}