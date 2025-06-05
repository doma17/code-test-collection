import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Integer>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        // Init
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        // Process
        bfs(x);

        // Output
        boolean isAns = true;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                isAns = false;
            }
        }
        if (isAns) {
            System.out.println("-1");
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : list[cur]) {
                if (distance[next] == -1) {  // 아직 방문하지 않은 경우
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }
 }