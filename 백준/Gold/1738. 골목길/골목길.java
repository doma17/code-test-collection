import java.io.*;
import java.util.*;

class Main {

    class Edge {
        int a, b, c;
        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    final int MAX_VALUE = 2000000000;
    final int MIN_VALUE = -2000000000;

    int n, m;
    int[] distance;
    int[] pre;
    ArrayList<Edge> edges;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        pre = new int[n + 1];
        Arrays.fill(distance, MIN_VALUE);
        Arrays.fill(pre, -1);
        distance[1] = 0;

        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        for (int i = 1; i < n; i++) {
            for (Edge e : edges) {
                if (distance[e.b] < distance[e.a] + e.c) {
                    distance[e.b] = distance[e.a] + e.c;
                    pre[e.b] = e.a;
                }
            }
        }
        // 양수 사이클 형성시 최대 경로가 존재하지 않음
        if (distance[n] == MIN_VALUE) {
            bw.write("-1\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        for (Edge e: edges) {
            if (distance[e.a] == MIN_VALUE) continue;
            if (distance[e.b] < distance[e.a] + e.c && isCycleOnPath(e.b)) {
                bw.write("-1\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n;
        sb.append(i);
        while (pre[i] != -1) {
            sb.insert(0, pre[i] + " ");
            i = pre[i];
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean isCycleOnPath(int target) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);

        while (!queue.isEmpty()) {
            int cnt = queue.poll();
            if (visited[cnt]) continue;
            visited[cnt] = true;

            for (Edge e : edges) {
                if (e.a == cnt && !visited[e.b])
                    queue.add(e.b);
            }
        }
        return visited[n];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
