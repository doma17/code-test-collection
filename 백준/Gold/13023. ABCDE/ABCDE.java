import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // Variable
    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int depth = 0;
    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        // Init
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // Process
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            DFS(i, 1);
            if (solved) {
                break;
            }
        }

        if (solved) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void DFS(int index, int depth) {
        if (depth == 5 || solved) { // 5명의 순차적인 친구사이 존재여부
            solved = true;
            return;
        }

        visited[index] = true;
        for (var next : list[index]) {
            if (!visited[next]) { 
                DFS(next, depth + 1);
            }
        }
        visited[index] = false;
    }
}